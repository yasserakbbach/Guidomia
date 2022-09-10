package com.yasserakbbach.guidomia.domain.di

import com.yasserakbbach.guidomia.domain.repository.CarRepository
import com.yasserakbbach.guidomia.domain.usecase.FilterCarsByMakeAndModelUseCase
import com.yasserakbbach.guidomia.domain.usecase.GetAllCarsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetAllCarsUseCase(
        carRepository: CarRepository,
    ): GetAllCarsUseCase =
        GetAllCarsUseCase(carRepository)

    @Provides
    fun provideFilterCarsByMakeAndModelUseCase(
        carRepository: CarRepository,
    ): FilterCarsByMakeAndModelUseCase =
        FilterCarsByMakeAndModelUseCase(carRepository)
}