package moe.sola.view_dsl.layout

import android.content.Context
import android.widget.EditText

/**
 * author: youhuajie
 * created on: 2020/3/19 10:30 AM
 * description:
 */
fun Context.editText(init: EditText.()-> Unit) = lazy {
    EditText(this).apply { init(this) }
}