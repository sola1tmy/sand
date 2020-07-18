package moe.sola.state

import android.util.Log
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

