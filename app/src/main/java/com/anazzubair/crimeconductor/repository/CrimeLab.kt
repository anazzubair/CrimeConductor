package com.anazzubair.crimeconductor.repository

import android.content.Context
import com.anazzubair.crimeconductor.model.Crime
import com.anazzubair.crimeconductor.utilities.SingletonHolder
import java.util.*

class CrimeLab private constructor(context: Context) {

    val crimes: MutableList<Crime>


    init {
        crimes = ArrayList()
        for (i in 0..99) {
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.isSolved = i % 2 == 0
            crimes.add(crime)
        }
    }

    fun getCrime(id: UUID): Crime? {
        for (crime in crimes) {
            if (crime.id == id) {
                return crime
            }
        }

        return null
    }

    companion object : SingletonHolder<CrimeLab, Context>(::CrimeLab)
}