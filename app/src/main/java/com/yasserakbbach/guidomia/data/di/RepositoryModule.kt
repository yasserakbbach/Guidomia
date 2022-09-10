package com.yasserakbbach.guidomia.data.di

import com.yasserakbbach.guidomia.data.local.CarDao
import com.yasserakbbach.guidomia.data.repository.CarRepositoryImpl
import com.yasserakbbach.guidomia.domain.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCarRepository(
        carDao: CarDao,
    ): CarRepository =
        CarRepositoryImpl(carDao)
}