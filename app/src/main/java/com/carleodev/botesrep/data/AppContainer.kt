package com.carleodev.botesrep.data


import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

interface AppContainer {
    val ticketStorageService: TicketStorageService
}


class AppDataContainer(private val context: Context ) : AppContainer {
    override val ticketStorageService:TicketStorageService by lazy {
        TicketStorageServiceImp(Firebase.firestore)
    }

}