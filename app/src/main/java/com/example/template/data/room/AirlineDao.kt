package com.example.template.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirlineDao {

    @Query("SELECT * FROM airlines")
    fun getAll(): Flow<List<AirlineEntity>>

    @Query("SELECT * FROM airlines WHERE name = :name")
    fun getByName(name: String): Flow<List<AirlineEntity>>

    @Insert(onConflict = IGNORE)
    suspend fun addAirline(airlineEntity: AirlineEntity)
}