package moe.sola.view_dsl

import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

/**
 * author: youhuajie
 * created on: 2020/3/19 10:24 AM
 * description:
 */
//todo 看看sp是怎么实现的
fun <VIEW> Context.customView() {

}

fun Context.textView(init: TextView.()-> Unit) = lazy {
    TextView(this).apply { init(this) }
}

fun Context.editText(init: EditText.()-> Unit) = lazy {
    EditText(this).apply { init(this) }
}


