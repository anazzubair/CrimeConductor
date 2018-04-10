package com.anazzubair.crimeconductor.crimelist

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anazzubair.crimeconductor.CrimeConductorApplication

import com.anazzubair.crimeconductor.R
import com.anazzubair.crimeconductor.di.subcomponent.crimelist.CrimeListControllerModule
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import javax.inject.Inject

class CrimeListController : MvpController<CrimeListContract.View, CrimeListContract.Presenter>(), CrimeListContract.View {

    private lateinit var crimeListAdapter: CrimeListAdapter
    @Inject lateinit var crimeListPresenter: CrimeListPresenter

    override fun createPresenter(): CrimeListContract.Presenter = crimeListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        CrimeConductorApplication.component
                .plus(CrimeListControllerModule())
                .injectTo(this)

        val view = inflater.inflate(R.layout.crime_list, container, false) as RecyclerView
        view.layoutManager = LinearLayoutManager(container.context)
        this.crimeListAdapter = CrimeListAdapter {}
        view.adapter = this.crimeListAdapter
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        this.crimeListAdapter.updateCrimes(presenter.getCrimeList(view.context))
    }
}
