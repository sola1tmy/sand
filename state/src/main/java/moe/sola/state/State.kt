package moe.sola.state

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import moe.sola.livedataext.updateValue

/**
 * author: youhuajie
 * created on: 2019-08-22 09:25
 * description:
 */
class State (
    val type: Int,
    val error: Throwable? = null,
    val ext: Any? = null
) {

    companion object {
        const val STATE_START = 0
        const val STATE_COMPLETE = 1
        const val STATE_ERROR = 2

        val START = State(STATE_START)
        val COMPLETE = State(STATE_COMPLETE)

        fun error(error: Throwable): State = State(STATE_ERROR, error)
    }

}

/**
 * Maybe在数据流式null的情况下会走OnComplete
 */
fun <T> Maybe<T>.bindState(stateLiveData: MutableLiveData<State>): Maybe<T> {
    return compose { upstream ->
        upstream.doOnSubscribe { stateLiveData.updateValue(State.START) }
            .doOnComplete { stateLiveData.updateValue(State.COMPLETE) }
            .doOnSuccess { stateLiveData.updateValue(State.COMPLETE) }
            .doOnError { stateLiveData.updateValue(State.error(it)) }
            .doOnDispose { stateLiveData.updateValue(State.COMPLETE) }
    }
}

fun Completable.bindState(stateLiveData: MutableLiveData<State>): Completable {
    return compose { upstream ->
        upstream.doOnSubscribe { stateLiveData.updateValue(State.START) }
            .doOnComplete { stateLiveData.updateValue(State.COMPLETE) }
            .doOnError { stateLiveData.updateValue(State.error(it)) }
            .doOnDispose { stateLiveData.updateValue(State.COMPLETE) }
    }
}