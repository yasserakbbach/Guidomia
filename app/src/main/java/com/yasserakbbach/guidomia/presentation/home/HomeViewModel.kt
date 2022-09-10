package com.yasserakbbach.guidomia.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasserakbbach.guidomia.domain.model.Car
import com.yasserakbbach.guidomia.domain.model.MakeAndModel
import com.yasserakbbach.guidomia.domain.usecase.FilterCarsByMakeAndModelUseCase
import com.yasserakbbach.guidomia.domain.usecase.GetAllCarsUseCase
import com.yasserakbbach.guidomia.presentation.home.mapper.toCarUiModel
import com.yasserakbbach.guidomia.presentation.home.model.HomeEvent
import com.yasserakbbach.guidomia.presentation.home.model.HomeState
import com.yasserakbbach.guidomia.util.Constants.DELAY_FILTER_QUERY
import com.yasserakbbach.guidomia.util.Constants.LOAD_CARS_DELAY
import com.yasserakbbach.guidomia.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCarsUseCase: GetAllCarsUseCase,
    private val filterCarsByMakeAndModelUseCase: FilterCarsByMakeAndModelUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private var searchJob: Job? = null

    init {
        loadAllCars()
    }

    private fun loadAllCars() {
        viewModelScope.launch {
            getAllCarsUseCase().collectLatest { res ->
                renderResults(res)
            }
        }
    }

    private suspend fun renderResults(res: Resource<List<Car>>) {
        state = when (res) {
            is Resource.Error -> {
                state.copy(isLoading = true)
            }
            is Resource.Loading -> {
                state.copy(isLoading = true)
            }
            is Resource.Success -> {
                delay(LOAD_CARS_DELAY)
                state.copy(
                    isLoading = false,
                    cars = res.data?.map { it.toCarUiModel() } ?: emptyList(),
                )
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.OnCarToggled -> event.updateState()
            is HomeEvent.OnMakeChanged -> event.updateState()
            is HomeEvent.OnModelChanged -> event.updateState()
        }
    }

    private fun HomeEvent.OnCarToggled.updateState() {
        state = state.copy(lastSelectedCar = carId)
    }

    private fun HomeEvent.OnMakeChanged.updateState() {
        state = state.copy(queryMake = make)
        filterCars()
    }

    private fun HomeEvent.OnModelChanged.updateState() {
        state = state.copy(queryModel = model)
        filterCars()
    }

    private fun filterCars() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(DELAY_FILTER_QUERY)
            filterCarsByMakeAndModelUseCase(
                MakeAndModel(state.queryMake, state.queryModel)
            ).collectLatest { res ->
                renderResults(res)
            }
        }
    }
}