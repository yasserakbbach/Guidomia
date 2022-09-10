package com.yasserakbbach.guidomia.presentation.home.model

data class HomeState(
    val cars: List<CarUiModel> = emptyList(),
    val lastSelectedCar: Int = -1,
    val queryMake: String = "",
    val queryModel: String = "",
    val isLoading: Boolean = false,
)
