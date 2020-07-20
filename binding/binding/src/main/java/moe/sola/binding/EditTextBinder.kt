package moe.sola.gourmetmap

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import moe.sola.binding.TwoWayBinder

/**
 * author: youhuajie
 * created on: 2020/7/16 3:49 PM
 * description:
 */
class EditTextBinder(private val editText: EditText) : TwoWayBinder<EditText, String>() {

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (liveData.value != s.toString()) {
                liveData.value = s.toString()
            }
        }
    }


    private val observer: Observer<String> = Observer<String> {
        if (it != editText.text.toString()) {
            editText.setText(it)
        }
    }

    private lateinit var liveData: MutableLiveData<String>
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun observeField(
        lifecycleOwner: LifecycleOwner,
        mutableLiveData: MutableLiveData<String>
    ) {
        this.lifecycleOwner = lifecycleOwner
        liveData = mutableLiveData
        setListener()
        liveData.observe(lifecycleOwner, observer)
    }


    private fun setListener() {
        editText.removeTextChangedListener(textWatcher)
        editText.addTextChangedListener(textWatcher)
    }

}

val EditText.bindText get() = EditTextBinder(this)