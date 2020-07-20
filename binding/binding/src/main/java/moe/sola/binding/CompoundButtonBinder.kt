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

    private lateinit var lifecycleOwner: LifecycleOwner
    private lateinit var liveData: MutableLiveData<Boolean>
    private val listener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        if (liveData.value != isChecked) {
            liveData.value = isChecked
        }
    }
    private val observer = Observer<Boolean> {
        if (it != compoundButton.isChecked) {
            compoundButton.isChecked = it
        }
    }

    override fun observeField(lifecycleOwner: LifecycleOwner, mutableLiveData: MutableLiveData<Boolean>) {
        liveData = mutableLiveData
        this.lifecycleOwner = lifecycleOwner
        setListener()
        liveData.observe(lifecycleOwner, observer)
    }


    private fun setListener() {
        compoundButton.setOnCheckedChangeListener(null)
        compoundButton.setOnCheckedChangeListener(listener)
    }


}

val CompoundButton.bindCheck get() = CompoundButtonBinder(this)