package com.yasserakbbach.guidomia.domain.usecase

import com.yasserakbbach.guidomia.domain.model.Car
import com.yasserakbbach.guidomia.domain.repository.CarRepository
import com.yasserakbbach.guidomia.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllCarsUseCase(
    private val carRepository: CarRepository,
) {

    suspend operator fun invoke(): Flow<Resource<List<Car>>> =
        carRepository.getAllCars()
}