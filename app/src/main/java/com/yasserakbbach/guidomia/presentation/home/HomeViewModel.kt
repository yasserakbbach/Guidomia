package com.yasserakbbach.guidomia.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasserakbbach.guidomia.domain.usecase.GetAllCarsUseCase
import com.yasserakbbach.guidomia.presentation.home.mapper.toCarUiModel
import com.yasserakbbach.guidomia.presentation.home.model.HomeState
import com.yasserakbbach.guidomia.util.Constants
import com.yasserakbbach.guidomia.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCarsUseCase: GetAllCarsUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        loadAllCars()
    }

    private fun loadAllCars() {
        viewModelScope.launch {
            getAllCarsUseCase().collectLatest { res ->
                state = when(res) {
                    is Resource.Error -> {
                        state.copy(isLoading = true)
                    }
                    is Resource.Loading -> {
                        state.copy(isLoading = true)
                    }
                    is Resource.Success -> {
                        delay(Constants.LOAD_CARS_DELAY)
                        state.copy(
                            isLoading = false,
                            cars = res.data?.map { it.toCarUiModel() } ?: emptyList(),
                        )
                    }
                }
            }
        }
    }
}