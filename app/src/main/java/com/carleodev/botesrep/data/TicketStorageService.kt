package com.carleodev.botesrep.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow

interface TicketStorageService {
    val firestore: FirebaseFirestore
    val tasks: Flow<List<ResumenVenta>>
    suspend fun getTask(taskId: String): ResumenVenta?
    suspend fun save(task: ResumenVenta): String
    suspend fun update(task: ResumenVenta)
    suspend fun delete(taskId: String)
}
