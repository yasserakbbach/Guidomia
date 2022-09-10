package com.yasserakbbach.guidomia.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars_table")
data class CarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val image: String,
    val customerPrice: Double,
    val make: String,
    val marketPrice: Double,
    val model: String,
    val consList: List<String>,
    val prosList: List<String>,
    val rating: Int,
)
