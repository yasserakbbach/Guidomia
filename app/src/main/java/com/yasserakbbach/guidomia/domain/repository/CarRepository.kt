package com.yasserakbbach.guidomia.domain.repository

import com.yasserakbbach.guidomia.domain.model.Car
import com.yasserakbbach.guidomia.domain.model.MakeAndModel
import com.yasserakbbach.guidomia.util.Resource
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    suspend fun getAllCars(): Flow<Resource<List<Car>>>
    suspend fun filterCarsByMakeAndModel(makeAndModel: MakeAndModel): Flow<Resource<List<Car>>>
}