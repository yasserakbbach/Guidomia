package com.yasserakbbach.guidomia.presentation.home.mapper

import com.yasserakbbach.guidomia.domain.model.Car
import com.yasserakbbach.guidomia.presentation.home.model.CarUiModel

fun Car.toCarUiModel(): CarUiModel =
    CarUiModel(
        id = id,
        image = image,
        make = make,
        marketPrice = marketPrice.toFormattedPrice(),
        model = model,
        consList = consList,
        prosList = prosList,
        rating = rating,
    )

private fun Double.toFormattedPrice(): String =
    div(1000).toInt().toString().plus("K")