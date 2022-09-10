package com.yasserakbbach.guidomia.data.repository

import com.yasserakbbach.guidomia.data.local.CarDao
import com.yasserakbbach.guidomia.data.mapper.toCar
import com.yasserakbbach.guidomia.domain.model.Car
import com.yasserakbbach.guidomia.domain.model.MakeAndModel
import com.yasserakbbach.guidomia.domain.repository.CarRepository
import com.yasserakbbach.guidomia.util.Constants
import com.yasserakbbach.guidomia.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map

class CarRepositoryImpl(
    private val carDao: CarDao,
) : CarRepository {

    override suspend fun getAllCars(): Flow<Resource<List<Car>>> =
        flow {
            emit(Resource.Loading())
            val cars = carDao.getAllCars().map { entities ->
                entities.map { it.toCar() }
            }
            emit(Resource.Success(cars.first()))
        }

    override suspend fun filterCarsByMakeAndModel(makeAndModel: MakeAndModel): Flow<Resource<List<Car>>> {
        TODO("Not yet implemented")
    }
}