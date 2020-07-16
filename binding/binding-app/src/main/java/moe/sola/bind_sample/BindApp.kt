package moe.sola.bind_sample

import android.app.Application
import moe.sola.android.common.Sand

/**
 * author: youhuajie
 * created on: 2020/7/16 3:22 PM
 * description:
 */
class BindApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Sand.setup(this)
    }
}