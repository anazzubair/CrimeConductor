package com.anazzubair.crimeconductor.di.subcomponent.main

import com.anazzubair.crimeconductor.activity.MainActivity
import com.anazzubair.crimeconductor.crimelist.CrimeListPresenter
import com.anazzubair.crimeconductor.di.ActivityModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity)