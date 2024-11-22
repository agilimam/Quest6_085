package com.example.pertmuan8pam.ui.view

import androidx.lifecycle.ViewModel
import com.example.pertmuan8pam.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RencanaStudyViewModel:ViewModel(){
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> =_krsState.asStateFlow()

}
