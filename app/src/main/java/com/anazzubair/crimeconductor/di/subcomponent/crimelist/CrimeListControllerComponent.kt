package com.anazzubair.crimeconductor.di.subcomponent.crimelist

import com.anazzubair.crimeconductor.crimelist.CrimeListController
import com.anazzubair.crimeconductor.crimelist.CrimeListPresenter
import com.anazzubair.crimeconductor.di.scope.ControllerScope
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Singleton

@ControllerScope
@Subcomponent(modules = [(CrimeListControllerModule::class)])
interface CrimeListControllerComponent{

    fun injectTo(crimeListController: CrimeListController)
}