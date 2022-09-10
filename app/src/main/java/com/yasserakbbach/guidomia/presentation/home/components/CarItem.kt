package com.yasserakbbach.guidomia.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.yasserakbbach.guidomia.R
import com.yasserakbbach.guidomia.presentation.home.model.CarUiModel
import com.yasserakbbach.guidomia.ui.theme.DarkGray
import com.yasserakbbach.guidomia.ui.theme.ExtraSmallPadding
import com.yasserakbbach.guidomia.ui.theme.NormalPadding
import com.yasserakbbach.guidomia.ui.theme.Orange
import com.yasserakbbach.guidomia.ui.theme.OrangeAlpha50
import com.yasserakbbach.guidomia.ui.theme.RatingStarSize
import com.yasserakbbach.guidomia.ui.theme.SmallPadding
import com.yasserakbbach.guidomia.util.SampleData

@Composable
fun CarItem(
    carUiModel: CarUiModel = SampleData.generateCarUiModel(),
) {
    val context = LocalContext.current
    val image = context.resources.getIdentifier(carUiModel.image, "drawable", context.packageName)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(NormalPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = image,
            contentDescription = carUiModel.model,
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = SmallPadding),
        ) {
            Text(
                text = carUiModel.model,
                color = DarkGray,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = stringResource(R.string.car_item_price_label_format, carUiModel.marketPrice),
                color = DarkGray,
                style = MaterialTheme.typography.bodySmall,
            )
            RatingBar(
                value = carUiModel.rating.toFloat(),
                onValueChange = {},
                onRatingChanged = {},
                config = RatingBarConfig().activeColor(Orange)
                    .inactiveColor(OrangeAlpha50)
                    .size(RatingStarSize),
                modifier = Modifier.padding(top = ExtraSmallPadding),
            )
        }
    }
}