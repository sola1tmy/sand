package moe.sola.state_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.flow.Flow
import moe.sola.state.IStateHandler
import moe.sola.state.State

/**
 * author: youhuajie
 * created on: 2020/3/17 11:18 AM
 * description:
 */
fun <T> Flow<T>.bind(stateHandler: IStateHandler): Flow<T> {
    val liveData = MutableLiveData<State>()
    liveData.observe(stateHandler.lifecycleOwner, Observer {
        stateHandler.doByState(it)
    })
    return bindState(liveData)
}