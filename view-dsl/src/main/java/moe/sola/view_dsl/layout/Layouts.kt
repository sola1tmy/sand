package moe.sola.view_dsl.layout

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.LinearLayoutCompat
import moe.sola.unit.Length
import moe.sola.view_dsl.lp.matchParent
import moe.sola.view_dsl.lp.wrapContent

/**
 * author: youhuajie
 * created on: 2020/3/19 10:30 AM
 * description:
 */
class _LinearLayoutCompat(context: Context): LinearLayoutCompat(context) {

    operator fun View.invoke(width: Length = matchParent, height: Length = wrapContent, init: LayoutParams.()-> Unit = {}) {
        val lp: LayoutParams = LayoutParams(width.px().toInt(), height.px().toInt())
        init.invoke(lp)
        addView(this, lp)
    }

}

class _RelativeLayoutCompat(context: Context): RelativeLayout(context) {

}