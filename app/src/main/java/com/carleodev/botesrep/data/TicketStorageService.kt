package com.carleodev.botesrep.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow


interface TicketStorageService {
    val firestore: FirebaseFirestore
    val tasks: Flow<List<TicketNube>>
    suspend fun getTask(taskId: String): TicketNube?
    suspend fun save(task: TicketNube): String
    suspend fun update(task: TicketNube)
    suspend fun delete(taskId: String)
}