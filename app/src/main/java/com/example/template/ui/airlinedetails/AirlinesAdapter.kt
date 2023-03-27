package com.example.template.ui.airlinedetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.template.databinding.ItemAirlineBinding
import com.example.template.domain.entity.Airline

class AirlinesAdapter : ListAdapter<Airline, AirlineViewHolder>(AirlineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAirlineBinding.inflate(inflater, parent, false)
        return AirlineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AirlineViewHolder, position: Int) {
        val airline = getItem(position)
        with(holder.binding) {
            titleTv.text = airline.title
            timeTv.text = airline.time
            terminalTv.text = airline.terminal
        }
    }
}

class AirlineViewHolder(val binding: ItemAirlineBinding) : ViewHolder(binding.root)

class AirlineDiffCallback : DiffUtil.ItemCallback<Airline>() {
    override fun areItemsTheSame(oldItem: Airline, newItem: Airline): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Airline, newItem: Airline): Boolean {
        return oldItem == newItem
    }
}