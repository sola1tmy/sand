package moe.sola.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.core.Maybe

/**
 * author: youhuajie
 * created on: 2020/3/17 11:18 AM
 * description:
 */
fun <T> Maybe<T>.bind(stateHandler: IStateHandler): Maybe<T> {
    val liveData = MutableLiveData<State>()
    liveData.observe(stateHandler.lifecycleOwner, Observer {
        stateHandler.doByState(it)
    })
    return bindState(liveData)
}