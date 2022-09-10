package com.yasserakbbach.guidomia.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

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
        HomeHeader(modifier = Modifier.padding(padding))
    }
}