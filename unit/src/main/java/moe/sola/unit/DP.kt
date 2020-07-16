package moe.sola.unit

import moe.sola.android.common.SandApp

/**
 * author: youhuajie
 * created on: 2020/7/14 4:20 PM
 * description:
 */
data class DP(val value: Float): Length {

    override fun px(): Float {
        return SandApp.resources.displayMetrics.density * value
    }

}

val Int.dp: DP get() = DP(this.toFloat())
val Float.dp: DP get() = DP(this.toFloat())
val Double.dp: DP get() = DP(this.toFloat())