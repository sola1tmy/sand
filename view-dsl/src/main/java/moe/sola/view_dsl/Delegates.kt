package moe.sola.view_dsl

import android.widget.RadioGroup
import androidx.appcompat.widget.*
import moe.sola.view_dsl.layout.ILayout
import moe.sola.view_dsl.layout._LinearLayoutCompat

/**
 * author: youhuajie
 * created on: 2020/3/19 10:24 AM
 * description:
 */
fun ILayout.textView(init: AppCompatTextView.() -> Unit) = lazy {
    AppCompatTextView(context).apply { init(this) }
}

fun ILayout.button(init: AppCompatButton.() -> Unit) = lazy {
    AppCompatButton(context).apply { init(this) }
}

fun ILayout.imageView(init: AppCompatImageView.() -> Unit) = lazy {
    AppCompatImageView(context).apply { init(this) }
}

fun ILayout.imageButton(init: AppCompatImageButton.() -> Unit) = lazy {
    AppCompatImageButton(context).apply { init(this) }
}

fun ILayout.editText(init: AppCompatEditText.() -> Unit) = lazy {
    AppCompatEditText(context).apply { init(this) }
}

fun ILayout.checkbox(init: AppCompatCheckBox.() -> Unit) = lazy {
    AppCompatCheckBox(context).apply { init(this) }
}

fun ILayout.seekBar(init: AppCompatSeekBar.() -> Unit) = lazy {
    AppCompatSeekBar(context).apply { init(this) }
}

fun ILayout.spinner(init: AppCompatSpinner.() -> Unit) = lazy {
    AppCompatSpinner(context).apply { init(this) }
}

fun ILayout.radioButton(init: AppCompatRadioButton.() -> Unit) = lazy {
    AppCompatRadioButton(context).apply { init(this) }
}

fun ILayout.ratingBar(init: AppCompatRatingBar.() -> Unit) = lazy {
    AppCompatRatingBar(context).apply { init(this) }
}

fun ILayout.toggleButton(init: AppCompatToggleButton.() -> Unit) = lazy {
    AppCompatToggleButton(context).apply { init(this) }
}

fun ILayout.autoCompleteTextView(init: AppCompatAutoCompleteTextView.() -> Unit) = lazy {
    AppCompatAutoCompleteTextView(context).apply { init(this) }
}

fun ILayout.multiAutoCompleteTextView(init: AppCompatMultiAutoCompleteTextView.() -> Unit) = lazy {
    AppCompatMultiAutoCompleteTextView(context).apply { init(this) }
}

fun ILayout.checkedTextView(init: AppCompatCheckedTextView.()-> Unit) {
    AppCompatCheckedTextView(context).apply { init(this) }
}


fun ILayout.verticalLayout(init: _LinearLayoutCompat.() -> Unit) = lazy {
    _LinearLayoutCompat(context).apply {
        orientation = LinearLayoutCompat.VERTICAL
        init(this)
    }
}

fun ILayout.horizontalLayout(init: LinearLayoutCompat.() -> Unit) = lazy {
    LinearLayoutCompat(context).apply {
        orientation = LinearLayoutCompat.VERTICAL
        init(this)
    }
}