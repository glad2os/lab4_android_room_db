package com.example.template.domain.repository

import com.example.template.domain.entity.Airline
import kotlinx.coroutines.flow.Flow

interface AirlineRepository {

    fun getAllAirlines(): Flow<List<Airline>>

    fun getAirlinesByName(name: String): Flow<List<Airline>>

    suspend fun addAirline(airline: Airline)
}