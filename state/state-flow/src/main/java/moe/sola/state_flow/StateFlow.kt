package moe.sola.state_flow

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import moe.sola.livedataext.updateValue
import moe.sola.state.State

/**
 * author: youhuajie
 * created on: 2020/7/18 2:50 PM
 * description:
 */
fun <T> Flow<T>.bindState(stateLiveData: MutableLiveData<State>): Flow<T> {
    return onStart { stateLiveData.updateValue(State.START) }
        .onCompletion { stateLiveData.updateValue(State.COMPLETE) }
        .catch { stateLiveData.updateValue(State.error(it)) }
}