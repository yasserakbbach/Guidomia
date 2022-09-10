package com.yasserakbbach.guidomia.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.yasserakbbach.guidomia.R
import com.yasserakbbach.guidomia.ui.theme.LargePadding

@Composable
fun HomeHeader(
    modifier: Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.tacoma),
            contentDescription = stringResource(R.string.home_screen_header_image_description),
        )
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
                .padding(LargePadding),
        ) {
            Text(
                text = stringResource(R.string.home_screen_header_title),
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.home_screen_header_subtitle),
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
            )
        }
    }
}