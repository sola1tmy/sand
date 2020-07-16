package moe.sola.binding

import android.widget.CompoundButton
import androidx.lifecycle.MutableLiveData

/**
 * author: youhuajie
 * created on: 2020/7/16 4:06 PM
 * description:
 */
class CompoundButtonBinder(private val compoundButton: CompoundButton):TwoWayBinder<CompoundButton, Boolean>() {

    private var set = false
    private lateinit var liveData: MutableLiveData<Boolean>
    private val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked -> liveData.value = isChecked }

    override fun widgetChange(value: Boolean) {
        removeListener()
        compoundButton.isChecked = value
        setListener()
    }

    override fun observeField(mutableLiveData: MutableLiveData<Boolean>) {
        liveData = mutableLiveData
        setListener()
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