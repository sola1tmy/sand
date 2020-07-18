package moe.sola.state_rx

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import moe.sola.livedataext.updateValue
import moe.sola.state.State

/**
 * author: youhuajie
 * created on: 2020/7/18 3:30 PM
 * description:
 */
/**
 * Maybe在数据流式null的情况下会走OnComplete
 */
internal fun <T> Maybe<T>.bindState(stateLiveData: MutableLiveData<State>): Maybe<T> {
    return doOnSubscribe { stateLiveData.updateValue(State.START) }
        .doOnComplete { stateLiveData.updateValue(State.COMPLETE) }
        .doOnSuccess {
            stateLiveData.updateValue(State.COMPLETE)
        }
        .doOnError {
            stateLiveData.updateValue(State.error(it))
//                stateLiveData.postValue(State.COMPLETE)
        }
        .doOnDispose { stateLiveData.updateValue(State.COMPLETE) }
}

fun Completable.bindState(stateLiveData: MutableLiveData<State>): Completable {
    return compose { upstream ->
        upstream.doOnSubscribe { stateLiveData.updateValue(State.START) }
            .doOnComplete { stateLiveData.updateValue(State.COMPLETE) }
            .doOnError { stateLiveData.updateValue(State.error(it)) }
            .doOnDispose { stateLiveData.updateValue(State.COMPLETE) }
    }
}