package moe.sola.state

import androidx.lifecycle.LifecycleOwner

/**
 * author: youhuajie
 * created on: 2020/3/17 11:11 AM
 * description:
 */
abstract class IStateHandler(val lifecycleOwner: LifecycleOwner) {

    abstract fun doByState(state: State?)

}