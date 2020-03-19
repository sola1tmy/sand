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
class _LinearLayoutCompt(context: Context): LinearLayoutCompat(context) {

    fun View.lparams(init: ViewGroup.LayoutParams.()-> Unit) {
        val lp: LayoutParams = LayoutParams(matchParent, wrapContent)
        init.invoke(lp)
        addView(this, lp)
    }

}