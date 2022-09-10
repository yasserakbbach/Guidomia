package com.yasserakbbach.guidomia.presentation.home.model

data class CarUiModel(
    val id: Int,
    val image: String,
    val make: String,
    val marketPrice: String,
    val model: String,
    val consList: List<String>,
    val prosList: List<String>,
    val rating: Int,
)
