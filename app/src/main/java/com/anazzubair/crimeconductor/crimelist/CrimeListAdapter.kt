package com.anazzubair.crimeconductor.crimelist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anazzubair.crimeconductor.R
import com.anazzubair.crimeconductor.model.Crime
import kotlinx.android.synthetic.main.crime_list_item.view.*

class CrimeListAdapter(private val itemClick: (Crime) -> Unit) : RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder>() {

    private val crimes = mutableListOf<Crime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CrimeViewHolder(parent, itemClick)

    override fun getItemCount(): Int = crimes.size

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) = holder.bind(crimes[position])

    fun updateCrimes(crimes: List<Crime>) {
        this.crimes.clear()
        this.crimes.addAll(crimes)
        notifyDataSetChanged()
    }

    class CrimeViewHolder(parent: ViewGroup, private val itemClick: (Crime) -> Unit)
                    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
                                                            .inflate(R.layout.crime_list_item, parent, false)) {

        fun bind(crime: Crime) {
            with(crime) {
                itemView.crimeTitle.text = title
                itemView.crimeDate.text = date.toString()
                itemView.crimeSolved.visibility = if (isSolved) View.VISIBLE else View.GONE
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}


