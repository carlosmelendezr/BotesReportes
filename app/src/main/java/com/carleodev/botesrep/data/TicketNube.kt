package com.carleodev.botesrep.data

import com.google.firebase.firestore.DocumentId

data class TicketNube(
    @DocumentId val id: String="",
    val fecha: Int=0,
    val iditem: Int=0,
    val hora: Int=0,
    val cant:Int=0,
    val anulado: Boolean = false,
    val color:Int=0,
    val tipopago:Int=0,
    val monto:Double
)