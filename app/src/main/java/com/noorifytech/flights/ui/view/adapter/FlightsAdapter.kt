package com.noorifytech.flights.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noorifytech.flights.R
import com.noorifytech.flights.data.repository.vo.FlightVO

class FlightsAdapter(private val context: Context, private val flights: List<FlightVO>) :
    RecyclerView.Adapter<FlightViewHolder>() {

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flightVO = getItem(position)
        if (flightVO != null) {
            holder.bind(context, flightVO)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val viewItem = LayoutInflater.from(context)
            .inflate(R.layout.activity_flight_search_result_list_item, parent, false)
        return FlightViewHolder(viewItem)
    }

    override fun getItemCount(): Int = flights.size

    private fun getItem(position: Int): FlightVO? {
        return if(flights.isNotEmpty()) flights[position] else null
    }
}