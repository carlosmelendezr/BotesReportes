package com.carleodev.botesrep.ui


import android.content.Context
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carleodev.botesrep.Util.convertDateToInt
import com.carleodev.botesrep.data.ResumenVenta

import com.carleodev.botesrep.data.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class ReporteDiaViewModel(savedStateHandle: SavedStateHandle,
                          private val ticketStorageService: TicketStorageService,
                          private val context: Context

) : ViewModel() {
    val hoy = convertDateToInt(Date())
    val listaResumenVenta = ticketStorageService.tasks



    companion object {
        private const val TIMEOUT_MILLIS = 5_000L

    }


}

//data class PagosUiState(val itemList: List<Pagos> = listOf())