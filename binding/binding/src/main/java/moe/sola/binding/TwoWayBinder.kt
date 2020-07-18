package moe.sola.binding

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

/**
 * author: youhuajie
 * created on: 2020/7/16 3:47 PM
 * description:
 */
abstract class TwoWayBinder<W, T> {

    abstract fun observeField(lifecycleOwner: LifecycleOwner, mutableLiveData: MutableLiveData<T>)

}