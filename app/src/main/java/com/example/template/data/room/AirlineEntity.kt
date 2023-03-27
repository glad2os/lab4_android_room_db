package com.example.template.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airlines")
data class AirlineEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val time: String,
    val terminal: String,
)