package moe.sola.sand.drawable.corner

import android.content.Context
import android.graphics.drawable.GradientDrawable

/**
 * author: youhuajie
 * created on: 2020-03-09 17:17
 * description:
 */
fun cornerDrawable(
    color: Int,
    corner: FloatArray = radius(0f),
    stroke: Stroke
) = GradientDrawable().apply {
    shape = GradientDrawable.RECTANGLE
    cornerRadii = corner
    setStroke(stroke.size, stroke.color, stroke.dashWidth, stroke.dashGap)
    setColor(color)
}


data class Stroke(val size: Int, val color: Int, val dashWidth: Float, val dashGap: Float)

fun radius(radius: Float): FloatArray {
    return floatArrayOf(radius, radius, radius, radius,
        radius, radius, radius, radius)
}