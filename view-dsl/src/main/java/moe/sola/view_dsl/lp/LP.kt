package moe.sola.view_dsl.lp

import android.view.ViewGroup
import moe.sola.unit.Length

/**
 * author: youhuajie
 * created on: 2020/3/19 10:33 AM
 * description:
 */
enum class LP(val value: Int): Length {

    MatchParent(ViewGroup.LayoutParams.MATCH_PARENT) {
        override fun px(): Float {
            return value.toFloat()
        }
    },
    WrapContent(ViewGroup.LayoutParams.WRAP_CONTENT) {
        override fun px(): Float {
            return value.toFloat()
        }

    }

}

val matchParent = LP.MatchParent
val wrapContent = LP.WrapContent