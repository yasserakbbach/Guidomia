package com.yasserakbbach.guidomia.data.mapper

import com.yasserakbbach.guidomia.data.local.CarEntity
import com.yasserakbbach.guidomia.domain.model.Car

fun Car.toCarEntity(): CarEntity =
    CarEntity(
        id,
        image,
        customerPrice,
        make,
        marketPrice,
        model,
        consList,
        prosList,
        rating,
    )

fun CarEntity.toCar(): Car =
    Car(
        id,
        image,
        customerPrice,
        make,
        marketPrice,
        model,
        consList,
        prosList,
        rating,
    )