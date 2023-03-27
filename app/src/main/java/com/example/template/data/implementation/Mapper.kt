package com.example.template.data.implementation

import com.example.template.data.room.AirlineEntity
import com.example.template.domain.entity.Airline

internal fun List<AirlineEntity>.toAirlineList() = map { it.toAirline() }

internal fun AirlineEntity.toAirline() = Airline(
    title = name,
    time = time,
    terminal = terminal,
)

internal fun Airline.toAirlineEntity() = AirlineEntity(
    name = title,
    time = time,
    terminal = terminal,
)
