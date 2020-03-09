package moe.sola.android.common

import android.app.Application
import moe.sola.android.common.exception.SandException

/**
 * author: youhuajie
 * created on: 2020-03-09 16:22
 * description:
 */
object Sand {

    internal lateinit var app: Application

    fun hold(app: Application) {
        this.app = app
    }

}

val SandApp: Application
    get() { return Sand.app}

@Suppress("UNCHECKED_CAST")
fun <T: Application> sandApp(): T {
    return Sand.app as T
}