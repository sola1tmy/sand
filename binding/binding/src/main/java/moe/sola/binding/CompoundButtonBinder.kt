package moe.sola.binding

import android.widget.CompoundButton
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * author: youhuajie
 * created on: 2020/7/16 4:06 PM
 * description:
 */
class CompoundButtonBinder(private val compoundButton: CompoundButton):TwoWayBinder<CompoundButton, Boolean>() {

    private var set = false
    private lateinit var lifecycleOwner: LifecycleOwner
    private lateinit var liveData: MutableLiveData<Boolean>
    private val listener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        liveData.removeObserver(observer)
        liveData.value = isChecked
        liveData.observe(lifecycleOwner, observer)
    }
    private val observer = Observer<Boolean> {
        removeListener()
        compoundButton.isChecked = it
        setListener()
    }

    override fun observeField(lifecycleOwner: LifecycleOwner, mutableLiveData: MutableLiveData<Boolean>) {
        liveData = mutableLiveData
        this.lifecycleOwner = lifecycleOwner
        setListener()
        liveData.observe(lifecycleOwner, observer)
    }


    fun setListener() {
        if (!set) {
            set = true
            compoundButton.setOnCheckedChangeListener(listener)
        }
    }

    fun removeListener() {
        compoundButton.setOnCheckedChangeListener(null)
        set = false
    }

}

val CompoundButton.bindCheck get() = CompoundButtonBinder(this)