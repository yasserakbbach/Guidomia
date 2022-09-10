package com.yasserakbbach.guidomia.data.di

import android.app.Application
import androidx.room.Room
import com.yasserakbbach.guidomia.data.local.CarDao
import com.yasserakbbach.guidomia.data.local.CarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCarDatabase(
        application: Application,
        roomCallback: CarDatabase.PrepopulateCallback,
    ): CarDatabase =
        Room.databaseBuilder(
            application,
            CarDatabase::class.java,
            "cars_db"
        )
        .fallbackToDestructiveMigration()
        .addCallback(roomCallback)
        .build()

    @Provides
    fun provideCarDao(
        carDatabase: CarDatabase,
    ): CarDao =
        carDatabase.carDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope = CoroutineScope(SupervisorJob())

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope
}