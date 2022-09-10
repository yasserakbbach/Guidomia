package com.yasserakbbach.guidomia.presentation.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.yasserakbbach.guidomia.presentation.home.components.CarItem
import com.yasserakbbach.guidomia.presentation.home.components.CarItemDetails
import com.yasserakbbach.guidomia.presentation.home.components.Filters
import com.yasserakbbach.guidomia.presentation.home.components.HomeHeader
import com.yasserakbbach.guidomia.presentation.home.components.HomeTopBar
import com.yasserakbbach.guidomia.presentation.home.model.HomeEvent
import com.yasserakbbach.guidomia.ui.theme.ExtraSmallPadding
import com.yasserakbbach.guidomia.ui.theme.NormalPadding
import com.yasserakbbach.guidomia.ui.theme.Orange

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                HomeHeader()
                Spacer(modifier = Modifier.height(ExtraSmallPadding))
                Filters(
                    modifier = Modifier.padding(NormalPadding),
                    homeViewModel = viewModel,
                )
            }
            if(state.isLoading) {
                item {
                    LinearProgressIndicator()
                }
            } else {
                items(state.cars) {
                    CarItem(it) { carId ->
                        viewModel.onEvent(HomeEvent.OnCarToggled(carId))
                    }
                    if(state.lastSelectedCar == it.id) {
                        CarItemDetails(
                            carUiModel = it,
                            modifier = Modifier.fillMaxWidth()
                                .padding(start = NormalPadding),
                        )
                    }
                    Divider(color = Orange)
                }
            }
        }
    }
}