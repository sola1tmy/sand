package moe.sola.sand.drawable

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.StateListDrawable
import androidx.annotation.ColorInt

/**
 * author: youhuajie
 * created on: 2020-03-09 17:14
 * description:
 */
fun layerDrawable(vararg drawable: Drawable?): LayerDrawable {
    return LayerDrawable(drawable.filterNotNull().toTypedArray())
}

fun colorDrawable(color: Int = Color.WHITE): ColorDrawable {
    return ColorDrawable(color)
}

fun stateColorDrawable(@ColorInt enableColor: Int, @ColorInt disableColor: Int, @ColorInt clickableColor: Int): StateListDrawable {
    return stateDrawable(colorDrawable(enableColor), colorDrawable(disableColor), colorDrawable(clickableColor))
}

fun stateDrawable(enableDrawable: Drawable, disableDrawable: Drawable = enableDrawable, clickDrawable: Drawable): StateListDrawable {
    return StateListDrawable().apply {
        addState(intArrayOf(android.R.attr.state_pressed), clickDrawable)
        addState(intArrayOf(android.R.attr.state_enabled, -android.R.attr.state_pressed), enableDrawable)
        addState(intArrayOf(-android.R.attr.state_enabled), disableDrawable)
    }
}