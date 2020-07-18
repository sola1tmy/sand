package moe.sola.binding

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * author: youhuajie
 * created on: 2020/7/16 3:49 PM
 * description:
 */
class EditTextBinder(private val editText: EditText) : TwoWayBinder<EditText, String>() {

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (liveData.value != s.toString()) {
                liveData.removeObserver(observer)
                liveData.value = s.toString()
                liveData.observe(lifecycleOwner, observer)
            }
        }
    }

    private val observer: Observer<String> = Observer<String>{
        removeListener()
        editText.setText(it)
        setListener()
    }

    private var set = false
    private lateinit var liveData: MutableLiveData<String>
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun observeField(lifecycleOwner: LifecycleOwner, mutableLiveData: MutableLiveData<String>) {
        this.lifecycleOwner = lifecycleOwner
        liveData = mutableLiveData
        setListener()
        liveData.observe(lifecycleOwner, observer)
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