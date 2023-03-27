package com.example.template.data.implementation

import com.example.template.data.room.AirlineDao
import com.example.template.domain.entity.Airline
import com.example.template.domain.repository.AirlineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AirlineRepositoryImpl(
    private val dao: AirlineDao
) : AirlineRepository {

    override fun getAllAirlines(): Flow<List<Airline>> {
        return dao.getAll().map { it.toAirlineList() }
    }

    override fun getAirlinesByName(name: String): Flow<List<Airline>> {
        return dao.getByName(name).map { it.toAirlineList() }
    }

    override suspend fun addAirline(airline: Airline) {
        dao.addAirline(airline.toAirlineEntity())
    }
}