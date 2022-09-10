package com.yasserakbbach.guidomia.presentation.home.model

sealed class HomeEvent {
    data class OnMakeChanged(val make: String) : HomeEvent()
    data class OnModelChanged(val model: String) : HomeEvent()
    data class OnCarToggled(val carId: Int) : HomeEvent()
}
