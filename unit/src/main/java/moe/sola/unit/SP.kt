package moe.sola.unit

import moe.sola.android.common.SandApp

/**
 * author: youhuajie
 * created on: 2020/7/16 3:12 PM
 * description:
 */
data class SP(val value: Float): Length {

    override fun px(): Float {
        val fontScale = SandApp.resources.displayMetrics.scaledDensity;
        return (value * fontScale + 0.5f);
    }

}

val Int.sp: SP get() = SP(this.toFloat())
val Float.sp: SP get() = SP(this.toFloat())
val Double.sp: SP get() = SP(this.toFloat())