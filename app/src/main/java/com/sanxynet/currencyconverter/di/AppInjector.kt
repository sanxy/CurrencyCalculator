package com.sanxynet.currencyconverter.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.sanxynet.currencyconverter.CurrencyApplication
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector

object AppInjector {
    fun init(ccApp: CurrencyApplication) {
        DaggerAppComponent.builder().application(ccApp)
            .build().inject(ccApp)
        ccApp
            .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    handleActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {

                }

                override fun onActivityResumed(activity: Activity) {

                }

                override fun onActivityPaused(activity: Activity) {

                }

                override fun onActivityStopped(activity: Activity) {

                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

                }

                override fun onActivityDestroyed(activity: Activity) {

                }
            })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasAndroidInjector) {
            AndroidInjection.inject(activity)
        }

    }
}
