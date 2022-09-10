package com.yasserakbbach.guidomia.domain.model

data class Car(
    val image: String,
    val customerPrice: Double,
    val make: String,
    val marketPrice: Double,
    val model: String,
    val consList: List<String>,
    val prosList: List<String>,
    val rating: Int,
)
