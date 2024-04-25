package com.carleodev.botesrep.ui


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carleodev.botesrep.Util.convertDateToInt
import com.carleodev.botesrep.data.ResumenVenta

import kotlinx.coroutines.flow.*
import java.util.*

class ReporteDiaViewModel(savedStateHandle: SavedStateHandle,

) : ViewModel() {
    val hoy = convertDateToInt(Date())
    val resumenVenta:ResumenVenta = ResumenVenta()


    companion object {
        private const val TIMEOUT_MILLIS = 5_000L

    }


}

//data class PagosUiState(val itemList: List<Pagos> = listOf())