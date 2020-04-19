package moe.sola.view_dsl.compat

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moe.sola.view_dsl.layout.ILayout

/**
 * author: youhuajie
 * created on: 2020/3/31 8:59 AM
 * description:
 */
fun ILayout.verticalRecyclerView(init: RecyclerView.()-> Unit) = lazy {
    RecyclerView(context).apply {
        layoutManager = LinearLayoutManager(context)
        init(this)
    }
}

fun ILayout.recyclerView(init: RecyclerView.()-> Unit) = lazy {
    RecyclerView(context).apply { init(this) }
}