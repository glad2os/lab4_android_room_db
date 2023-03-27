package com.example.template.ui.createentity

import androidx.lifecycle.ViewModel
import com.example.template.domain.entity.Airline
import com.example.template.domain.repository.AirlineRepository

class CreateEntityViewModel(
    private val repository: AirlineRepository
) : ViewModel() {

    suspend fun createAirline(airline: Airline) {
        repository.addAirline(airline)
    }
}