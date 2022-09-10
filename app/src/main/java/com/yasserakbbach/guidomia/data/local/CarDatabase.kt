package com.yasserakbbach.guidomia.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yasserakbbach.guidomia.R
import com.yasserakbbach.guidomia.data.di.DatabaseModule
import com.yasserakbbach.guidomia.data.mapper.toCarEntity
import com.yasserakbbach.guidomia.domain.model.Car
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [CarEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(CarDatabaseConverter::class)
abstract class CarDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    class PrepopulateCallback @Inject constructor(
        @DatabaseModule.ApplicationScope private val scope: CoroutineScope,
        @ApplicationContext private val context: Context,
        private val carDao: Provider<CarDao>,
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            scope.launch {
                val jsonText = context.resources.openRawResource(R.raw.car_list)
                    .bufferedReader().use { it.readText() }
                val carsList = Json.decodeFromString<List<Car>>(jsonText)
                carDao.get().insertCars(carsList.map { it.toCarEntity() })
            }
        }
    }
}