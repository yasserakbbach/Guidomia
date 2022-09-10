package com.yasserakbbach.guidomia.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.yasserakbbach.guidomia.presentation.home.components.Filters
import com.yasserakbbach.guidomia.presentation.home.components.HomeHeader
import com.yasserakbbach.guidomia.presentation.home.components.HomeTopBar
import com.yasserakbbach.guidomia.ui.theme.ExtraSmallPadding
import com.yasserakbbach.guidomia.ui.theme.NormalPadding

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            HomeHeader()
            Spacer(modifier = Modifier.height(ExtraSmallPadding))
            Filters(modifier = Modifier.padding(NormalPadding))
        }
    }
}