package com.noorifytech.flights.ui.view.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noorifytech.flights.R
import com.noorifytech.flights.data.repository.vo.FlightVO
import kotlinx.android.synthetic.main.activity_flight_search_result_list_item.view.*

class FlightViewHolder(private val viewItem: View) : RecyclerView.ViewHolder(viewItem) {

        fun bind(context: Context, flightVO: FlightVO) {

            // departure airline image
            Glide.with(context)
                .asBitmap()
                .load(flightVO.legs[0].getAirlineImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(viewItem.departureAirlineImageIV)

            viewItem.leg1DepartureTimeTV.text = flightVO.legs[0].departureTime
            viewItem.leg1ArrivalTimeTV.text = flightVO.legs[0].arrivalTime

            viewItem.departureStopsNameTV.text = if(flightVO.legs[0].stops > 0) "${flightVO.legs[1].stops} Stop(s)" else "Direct"
            viewItem.departureLegDuration.text = flightVO.legs[0].durationInMins

            viewItem.departureLegNameTV.text = "${flightVO.legs[0].departureAirport} - ${flightVO.legs[0].arrivalAirport}, "
            viewItem.departureAirlineNameTV.text = "${flightVO.legs[0].airlineName}"


            // arrival airline image
            Glide.with(context)
                .asBitmap()
                .load(flightVO.legs[1].getAirlineImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(viewItem.arrivalAirlineImageIV)

            viewItem.leg2DepartureTimeTV.text = flightVO.legs[1].departureTime
            viewItem.leg2ArrivalTimeTV.text = flightVO.legs[1].arrivalTime

            viewItem.arrivalStopsNameTV.text = if(flightVO.legs[1].stops > 0) "${flightVO.legs[1].stops} Stops" else "Direct"
            viewItem.arrivalLegDuration.text = flightVO.legs[1].durationInMins

            viewItem.arrivalLegNameTV.text = "${flightVO.legs[1].departureAirport} - ${flightVO.legs[1].arrivalAirport}, "
            viewItem.arrivalAirlineNameTV.text = "${flightVO.legs[1].airlineName}"

            // Price and Agent
            viewItem.itineraryPriceTV.text = "${flightVO.itinerary.price}"
            viewItem.itineraryAgentNameTV.text = "via ${flightVO.itinerary.agent}"


        }
    }