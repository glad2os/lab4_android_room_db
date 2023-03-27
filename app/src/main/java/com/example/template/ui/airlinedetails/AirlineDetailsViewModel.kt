package com.example.template.ui.airlinedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.template.domain.repository.AirlineRepository

class AirlineDetailsViewModel(
    private val title: String,
    private val repository: AirlineRepository
) : ViewModel() {

    val airlines get() = repository.getAirlinesByName(title)

    class Factory(private val repository: AirlineRepository) {
        fun create(title: String) = AirlineDetailsViewModel(title, repository)
    }

    companion object {
        fun factory(f: Factory, title: String) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return f.create(title) as T
            }
        }
    }
}