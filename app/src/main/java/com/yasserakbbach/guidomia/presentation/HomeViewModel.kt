package com.yasserakbbach.guidomia.presentation

import androidx.lifecycle.ViewModel
import com.yasserakbbach.guidomia.domain.usecase.GetAllCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCarsUseCase: GetAllCarsUseCase,
) : ViewModel() {
}