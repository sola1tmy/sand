package moe.sola.view_dsl.layout

import android.app.Activity
import android.content.Context
import android.view.View

/**
 * author: youhuajie
 * created on: 2020/3/28 3:40 PM
 * description:
 */
interface ILayout {
    val context: Context

    val layout: View
}

fun Activity.setContentView(layout: ILayout) {
    setContentView(layout.layout)
}