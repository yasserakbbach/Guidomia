package com.yasserakbbach.guidomia.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.yasserakbbach.guidomia.R
import com.yasserakbbach.guidomia.presentation.home.HomeViewModel
import com.yasserakbbach.guidomia.presentation.home.model.HomeEvent
import com.yasserakbbach.guidomia.ui.theme.DarkGray
import com.yasserakbbach.guidomia.ui.theme.ExtraSmallPadding
import com.yasserakbbach.guidomia.ui.theme.NormalPadding
import com.yasserakbbach.guidomia.ui.theme.SmallPadding

@ExperimentalMaterial3Api
@Composable
fun Filters(
    modifier: Modifier,
    homeViewModel: HomeViewModel,
) {
    val state = homeViewModel.state

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = DarkGray,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(NormalPadding),
        ) {
            Text(
                text = stringResource(R.string.home_screen_filters_title),
                color = Color.White,
                modifier = Modifier.padding(start = NormalPadding, top = ExtraSmallPadding),
            )
            TextField(
                value = state.queryMake,
                onValueChange = {
                    homeViewModel.onEvent(HomeEvent.OnMakeChanged(it))
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.home_Screen_filter_by_make),
                        color = DarkGray,
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = NormalPadding, end = NormalPadding),
            )
            TextField(
                value = state.queryModel,
                onValueChange = {
                    homeViewModel.onEvent(HomeEvent.OnModelChanged(it))
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.home_Screen_filter_by_model),
                        color = DarkGray,
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = NormalPadding, end = NormalPadding, bottom = SmallPadding),
            )
        }
    }
}