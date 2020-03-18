package moe.sola.android.common

import android.app.Application
import moe.sola.android.common.pool.Pool

/**
 * author: youhuajie
 * created on: 2020-03-09 16:22
 * description:
 */
object Sand {

    internal lateinit var app: Application

    fun setup(app: Application) {
        this.app = app
        Pool.registerLifeCycle(app)
    }

}

val SandApp: Application
    get() { return Sand.app}

@Suppress("UNCHECKED_CAST")
fun <T: Application> sandApp(): T {
    return Sand.app as T
}