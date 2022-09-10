package com.yasserakbbach.guidomia.util

import com.yasserakbbach.guidomia.presentation.home.model.CarUiModel

object SampleData {

    fun generateCarUiModel(): CarUiModel =
        CarUiModel(
            1,
            image = "range_rover",
            make = "Land Rover",
            marketPrice = "125K",
            model = "Range Rover",
            consList = listOf(
                "Bad direction",
            ),
            prosList = listOf(
                "You can go everywhere",
                "Good sound system",
            ),
            rating = 3,
        )
}