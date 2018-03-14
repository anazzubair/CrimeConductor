package com.anazzubair.crimeconductor.crimelist

import android.content.Context
import com.anazzubair.crimeconductor.model.Crime
import com.anazzubair.crimeconductor.repository.CrimeLab
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class CrimeListPresenter : MvpBasePresenter<CrimeListContract.View>(), CrimeListContract.Presenter {

    override fun getCrimeList(context: Context): List<Crime> {
        return CrimeLab.getInstance(context).crimes
    }

}
