package com.yasserakbbach.guidomia.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.yasserakbbach.guidomia.R
import com.yasserakbbach.guidomia.ui.theme.Moul
import com.yasserakbbach.guidomia.ui.theme.Orange
import com.yasserakbbach.guidomia.ui.theme.SmallPadding

@Composable
fun HomeTopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Orange)
            .padding(SmallPadding),
    ) {
        Text(
            text = stringResource(R.string.home_screen_topbar_title),
            fontFamily = Moul,
            color = Color.White,
        )
        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = stringResource(R.string.home_screen_menu_description),
                tint = Color.White,
            )
        }
    }
}