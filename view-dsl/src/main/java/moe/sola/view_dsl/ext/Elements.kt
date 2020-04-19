package moe.sola.view_dsl.ext

import android.view.View
import android.view.ViewGroup
import android.view.ViewManager

/**
 * author: youhuajie
 * created on: 2020/3/19 10:35 AM
 * description:
 */
fun ViewGroup.line(): View {
    return View(context)
}

fun ViewGroup.space(): View {
    return View(context)
}