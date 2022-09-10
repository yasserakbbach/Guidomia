package com.yasserakbbach.guidomia.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.yasserakbbach.guidomia.R
import com.yasserakbbach.guidomia.presentation.home.model.CarUiModel
import com.yasserakbbach.guidomia.ui.theme.CircleProsAndConsSize
import com.yasserakbbach.guidomia.ui.theme.DarkGray
import com.yasserakbbach.guidomia.ui.theme.ExtraSmallPadding
import com.yasserakbbach.guidomia.ui.theme.LightGray
import com.yasserakbbach.guidomia.ui.theme.Orange
import com.yasserakbbach.guidomia.ui.theme.SmallPadding

@Composable
fun CarItemDetails(
    carUiModel: CarUiModel,
    modifier: Modifier,
) {
    val prosList = carUiModel.prosList.filter { it.isNotEmpty() }
    val consList = carUiModel.consList.filter { it.isNotEmpty() }
    Column(
        modifier = modifier.background(color = LightGray),
    ) {
        if(prosList.isNotEmpty()) {
            Text(
                text = stringResource(R.string.car_item_details_pros),
                color = DarkGray,
            )
        }
        prosList.forEach {
            Row(
                modifier = Modifier.padding(start = SmallPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Surface(
                    shape = CircleShape,
                    color = Orange,
                    modifier = Modifier.size(CircleProsAndConsSize),
                ) {}
                Text(
                    text = it,
                    modifier = Modifier.padding(start = ExtraSmallPadding),
                )
            }
        }
        if(consList.isNotEmpty()) {
            Text(
                text = stringResource(R.string.car_item_details_cons),
                color = DarkGray,
            )
        }
        consList.forEach {
            Row(
                modifier = Modifier.padding(start = SmallPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Surface(
                    shape = CircleShape,
                    color = Orange,
                    modifier = Modifier.size(CircleProsAndConsSize),
                ) {}
                Text(
                    text = it,
                    modifier = Modifier.padding(start = ExtraSmallPadding),
                )
            }
        }
    }
}