package com.anazzubair.crimeconductor.crimelist

import android.content.Context
import com.anazzubair.crimeconductor.model.Crime
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface CrimeListContract {
    interface View: MvpView
    interface Presenter: MvpPresenter<View> {
        fun getCrimeList(context: Context): List<Crime>
    }
}