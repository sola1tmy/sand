package moe.sola.sand.drawable.selectable

import android.content.Context
import android.graphics.drawable.Drawable
import moe.sola.android.common.SandApp

/**
 * author: youhuajie
 * created on: 2020/3/16 2:19 PM
 * description:
 */
fun selectableItemBackground(): Drawable? {
    val attrs = intArrayOf(android.R.attr.selectableItemBackground)
    val ta = SandApp.obtainStyledAttributes(attrs)
    val drawableFromTheme = ta.getDrawable(0 /* index */)
    ta.recycle()

    return drawableFromTheme
}

fun selectableItemBackgroundBorderless(): Drawable? {
    val attrs = intArrayOf(android.R.attr.selectableItemBackgroundBorderless)
    val ta = SandApp.obtainStyledAttributes(attrs)
    val drawableFromTheme = ta.getDrawable(0 /* index */)
    ta.recycle()

    return drawableFromTheme
}