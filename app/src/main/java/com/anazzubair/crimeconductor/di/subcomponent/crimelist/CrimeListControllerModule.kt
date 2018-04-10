package com.anazzubair.crimeconductor.di.subcomponent.crimelist

import com.anazzubair.crimeconductor.crimelist.CrimeListPresenter
import com.anazzubair.crimeconductor.di.scope.ControllerScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CrimeListControllerModule {

    @Provides @ControllerScope
    fun provideCrimeListPresenter() : CrimeListPresenter = CrimeListPresenter()
}