package moe.sola.android.common.pool

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.*

/**
 * author: youhuajie
 * created on: 2020/3/17 11:54 AM
 * description:
 */
object Pool {

    var componentPool = WeakHashMap<Activity, WeakHashMap<String, Any>>()

    fun <T> Activity.getComponent(key: String, defaultValue: () -> Any): T {
        val map = componentPool.getOrPut(this, { WeakHashMap() })
        return map.getOrPut(key, defaultValue) as T
    }

    fun registerLifeCycle(application: Application) {
        val callbacks = object : Application.ActivityLifecycleCallbacks {

            override fun onActivityPaused(activity: Activity) {}

            override fun onActivityStarted(activity: Activity) {}

            override fun onActivityDestroyed(activity: Activity) {
                componentPool.remove(activity)
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

            override fun onActivityResumed(activity: Activity) {}

        }

        application.registerActivityLifecycleCallbacks(callbacks)
    }
}