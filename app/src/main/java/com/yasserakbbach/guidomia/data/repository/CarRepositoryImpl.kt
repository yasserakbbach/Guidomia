package com.yasserakbbach.guidomia.data.repository

import com.yasserakbbach.guidomia.data.local.CarDao
import com.yasserakbbach.guidomia.data.mapper.toCarList
import com.yasserakbbach.guidomia.domain.model.Car
import com.yasserakbbach.guidomia.domain.model.MakeAndModel
import com.yasserakbbach.guidomia.domain.repository.CarRepository
import com.yasserakbbach.guidomia.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CarRepositoryImpl(
    private val carDao: CarDao,
) : CarRepository {

    override suspend fun getAllCars(): Flow<Resource<List<Car>>> =
        channelFlow {
            send(Resource.Loading())
            val flowListCar = carDao.getAllCars().map { it.toCarList()}
            flowListCar.collectLatest {
                send(Resource.Success(it))
            }
        }

    override suspend fun filterCarsByMakeAndModel(makeAndModel: MakeAndModel): Flow<Resource<List<Car>>> =
        flow {
            emit(Resource.Loading())
            val isModelQueryFilled = makeAndModel.model.isNotEmpty()
            val isMakeQueryFilled = makeAndModel.make.isNotEmpty()
            val areBothQueriesFilled = isMakeQueryFilled && isModelQueryFilled

            val flowCars = when {
                areBothQueriesFilled -> carDao.getAllCarsByMakeAndModel(
                    make = makeAndModel.make,
                    model = makeAndModel.model,
                )
                isModelQueryFilled -> carDao.getAllCarsByModel(makeAndModel.model)
                isMakeQueryFilled -> carDao.getAllCarsByMake(makeAndModel.make)
                else -> carDao.getAllCars()
            }

            emit(Resource.Success(flowCars.first().toCarList()))
        }
}