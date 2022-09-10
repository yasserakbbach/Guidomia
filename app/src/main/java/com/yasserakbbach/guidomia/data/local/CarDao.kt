package com.yasserakbbach.guidomia.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {

    @Query("SELECT * FROM cars_table")
    fun getAllCars(): Flow<List<CarEntity>>

    @Query("SELECT * FROM cars_table WHERE make LIKE '%' || :make || '%'")
    fun getAllCarsByMake(make: String): Flow<List<CarEntity>>

    @Query("SELECT * FROM cars_table WHERE model LIKE '%' || :model || '%'")
    fun getAllCarsByModel(model: String): Flow<List<CarEntity>>

    @Query("SELECT * FROM cars_table WHERE make LIKE '%' || :make || '%' OR model LIKE '%' || :model || '%'")
    fun getAllCarsByMakeAndModel(make: String, model: String): Flow<List<CarEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCars(cars: List<CarEntity>)
}