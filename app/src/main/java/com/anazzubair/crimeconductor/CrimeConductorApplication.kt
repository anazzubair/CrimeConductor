package com.anazzubair.crimeconductor

import android.app.Application
import com.anazzubair.crimeconductor.di.ApplicationComponent
import com.anazzubair.crimeconductor.di.ApplicationModule
import com.anazzubair.crimeconductor.di.DaggerApplicationComponent

class CrimeConductorApplication : Application() {
    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        component = DaggerApplicationComponent.builder()
                        .applicationModule(ApplicationModule(this))
                        .build()
    }
}