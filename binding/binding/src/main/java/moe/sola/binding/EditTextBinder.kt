package moe.sola.binding

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.MutableLiveData

/**
 * author: youhuajie
 * created on: 2020/7/16 3:49 PM
 * description:
 */
class EditTextBinder(private val editText: EditText) : TwoWayBinder<EditText, CharSequence>() {

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (liveData.value != s.toString()) {
                liveData.value = s.toString()
            }
        }
    }
    private var set = false
    private lateinit var liveData: MutableLiveData<CharSequence>

    override fun observeField(mutableLiveData: MutableLiveData<CharSequence>) {
        liveData = mutableLiveData
        setListener()
    }

    override fun widgetChange(value: CharSequence) {
        removeListener()
        editText.setText(value)
        setListener()
    }

    private fun setListener() {
        if (!set) {
            set = true
            editText.addTextChangedListener(textWatcher)
        }
    }

    private fun removeListener() {
        editText.removeTextChangedListener(textWatcher)
        set = false
    }
}

val EditText.bindText get() = EditTextBinder(this)