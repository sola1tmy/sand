package moe.sola.view_dsl.compat

import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moe.sola.view_dsl.layout.ILayout

/**
 * author: youhuajie
 * created on: 2020/3/31 3:54 PM
 * description:
 */
fun ILayout.toolbar(init: Toolbar.()-> Unit) = lazy {
    Toolbar(context).apply { init(this) }
}