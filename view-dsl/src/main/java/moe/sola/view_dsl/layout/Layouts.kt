package moe.sola.view_dsl.layout

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import moe.sola.view_dsl.lp.matchParent
import moe.sola.view_dsl.lp.wrapContent

/**
 * author: youhuajie
 * created on: 2020/3/19 10:30 AM
 * description:
 */
class _LinearLayoutCompat(context: Context): LinearLayoutCompat(context) {

    operator fun View.invoke(width: Int = matchParent, height: Int = wrapContent, init: LayoutParams.()-> Unit = {}) {
        val lp: LayoutParams = LayoutParams(matchParent, wrapContent)
        init.invoke(lp)
        addView(this, lp)
    }

}

class _RelativeLayoutCompat(context: Context): LinearLayoutCompat(context) {

}