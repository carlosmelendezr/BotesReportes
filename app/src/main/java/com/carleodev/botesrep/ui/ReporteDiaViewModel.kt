package com.carleodev.botesrep.ui


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carleodev.botesrep.Util.convertDateToInt

import kotlinx.coroutines.flow.*
import java.util.*

class ReporteDiaViewModel(savedStateHandle: SavedStateHandle,

) : ViewModel() {
    val hoy = convertDateToInt(Date())

    /*val boteAzul = ticketsRepository.getSumaBote(1, hoy)
    val boteAzulExp =  ticketsRepository.getSumaBote(3, hoy)
    val boteAmarillo = ticketsRepository.getSumaBote(2, hoy)
    val boteAmarilloExp = ticketsRepository.getSumaBote(4, hoy)
    val botesAnulados = ticketsRepository.getSumaBoteAnulado(hoy)

    val listaPagos: StateFlow<PagosUiState> =
        pagosRepository.getResumenPagos(hoy).map { PagosUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = PagosUiState())*/


    companion object {
        private const val TIMEOUT_MILLIS = 5_000L

    }


}

//data class PagosUiState(val itemList: List<Pagos> = listOf())