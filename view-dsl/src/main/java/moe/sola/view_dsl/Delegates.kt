package moe.sola.view_dsl

import android.content.Context
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import moe.sola.view_dsl.layout.ILayout
import moe.sola.view_dsl.layout._LinearLayoutCompat

/**
 * author: youhuajie
 * created on: 2020/3/19 10:24 AM
 * description:
 */
//todo 看看sp是怎么实现的
fun <VIEW> Context.customView() {

}

fun ILayout.textView(init: TextView.()-> Unit) = lazy {
    AppCompatTextView(context).apply { init(this) }
}

fun ILayout.imageView(init: ImageView.()-> Unit) = lazy {
    AppCompatImageView(context).apply { init(this) }
}

fun ILayout.editText(init: AppCompatEditText.()-> Unit) = lazy {
    AppCompatEditText(context).apply { init(this) }
}

fun ILayout.verticalLayout(init: _LinearLayoutCompat.()-> Unit) = lazy {
    _LinearLayoutCompat(context).apply {
        orientation = LinearLayoutCompat.VERTICAL
        init(this)
    }
}

fun ILayout.horizontalLayout(init: LinearLayoutCompat.()-> Unit) = lazy {
    LinearLayoutCompat(context).apply {
        orientation = LinearLayoutCompat.VERTICAL
        init(this)
    }
}