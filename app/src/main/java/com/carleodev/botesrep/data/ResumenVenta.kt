package com.carleodev.botesrep.data

import com.google.firebase.firestore.DocumentId

data class ResumenVenta(
    @DocumentId val id:String="",
    val boteAzules:Int=0,
    val boteAmarillo:Int=0,
    val anulados:Int=0,
    val pagosDivisa:Double=0.0,
    val pagosVenezuela:Double=0.0,
    val pagosBancaAmiga:Double=0.0,
    val pagosEfectivoBs:Double=0.0,
    val pagosMovil:Double=0.0
)
