package com.anazzubair.crimeconductor.di

import com.anazzubair.crimeconductor.crimelist.CrimeListController
import com.anazzubair.crimeconductor.di.subcomponent.crimelist.CrimeListControllerComponent
import com.anazzubair.crimeconductor.di.subcomponent.crimelist.CrimeListControllerModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    fun plus(crimeListControllerModule: CrimeListControllerModule): CrimeListControllerComponent
}