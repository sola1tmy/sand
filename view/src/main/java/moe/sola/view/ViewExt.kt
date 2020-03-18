package moe.sola.view

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

/**
 * author: youhuajie
 * created on: 2020/3/18 4:04 PM
 * description:
 */
var View.visibleOrGone: Boolean
    get() {
        return this.visibility == View.VISIBLE
    }
    set(v) {
        visibility = if (v) View.VISIBLE else View.GONE
    }

var View.visibleOrInvisible: Boolean
    get() {
        return this.visibility == View.VISIBLE
    }
    set(v) {
        visibility = if (v) View.VISIBLE else View.INVISIBLE
    }

fun View.roundCorner(roundCorner: Float) {
    clipToOutline = true
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, roundCorner)
        }
    }
}