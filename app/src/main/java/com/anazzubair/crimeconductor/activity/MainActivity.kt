package com.anazzubair.crimeconductor.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.anazzubair.crimeconductor.CrimeConductorApplication

import com.anazzubair.crimeconductor.R
import com.anazzubair.crimeconductor.crimelist.CrimeListController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        if(!router.hasRootController()) router.setRoot(RouterTransaction.with(CrimeListController()))
    }

    override fun onBackPressed() {
        if(!router.handleBack()) super.onBackPressed()
    }
}