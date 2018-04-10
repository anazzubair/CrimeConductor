package com.anazzubair.crimeconductor.di

import android.content.Context
import com.anazzubair.crimeconductor.CrimeConductorApplication
import com.anazzubair.crimeconductor.crimelist.CrimeListPresenter
import com.anazzubair.crimeconductor.di.qualifier.ApplicationQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: CrimeConductorApplication) {

    @Provides @Singleton
    fun provideApplication(): CrimeConductorApplication = application

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext(): Context = application
}