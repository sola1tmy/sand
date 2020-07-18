package moe.sola.binding

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * author: youhuajie
 * created on: 2020/7/13 2:12 PM
 * description:
 */
class Bindable(val owner: LifecycleOwner)  {

    val l: LifecycleOwner
        get() {
            return when(owner) {
                is Activity -> owner
                is Fragment -> (this as Fragment).viewLifecycleOwner
                else -> throw IllegalStateException("lifeCycleOwner could not be found in Bindable interface, please override it")
            }
        }

    fun <T> LiveData<T>.bind(action: (T)->Unit) {
        observe(l, Observer { action.invoke(it) })
    }

    fun <W, T> MutableLiveData<T>.twoWayBind(binder: TwoWayBinder<W, T>) {
        binder.observeField(l, this)
    }

}

fun LifecycleOwner.bindContext(bindActions: Bindable.()-> Unit) {
    bindActions.invoke(Bindable(this))
}