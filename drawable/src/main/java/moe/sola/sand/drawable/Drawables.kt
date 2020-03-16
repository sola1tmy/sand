package moe.sola.sand.drawable

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable

/**
 * author: youhuajie
 * created on: 2020-03-09 17:14
 * description:
 */
fun layerDrawable(vararg drawable: Drawable?): LayerDrawable {
    return LayerDrawable(drawable.filterNotNull().toTypedArray())
}

fun colorDrawable(color: Int = Color.WHITE): Drawable {
    return ColorDrawable(color)
}