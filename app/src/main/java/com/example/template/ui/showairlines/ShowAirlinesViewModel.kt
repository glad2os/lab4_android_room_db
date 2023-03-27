package com.example.template.ui.showairlines

import androidx.lifecycle.ViewModel
import com.example.template.domain.repository.AirlineRepository

class ShowAirlinesViewModel(
    private val repository: AirlineRepository
) : ViewModel() {

    val airlines get() = repository.getAllAirlines()
}