package com.carleodev.botesrep.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.perf.trace
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.tasks.await


class TicketStorageServiceImp(override val firestore: FirebaseFirestore) :TicketStorageService {

    override val tasks: Flow<List<TicketNube>>
        get() = emptyFlow()

    override suspend fun getTask(taskId: String): TicketNube? =
        firestore.collection(TASK_COLLECTION).document(taskId).get().await().toObject()

    override suspend fun save(task: TicketNube): String =
        trace(SAVE_TASK_TRACE) {
            firestore.collection(TASK_COLLECTION).add(task).await().id
        }

    override suspend fun update(task: TicketNube): Unit =
        trace(UPDATE_TASK_TRACE) {
            firestore.collection(TASK_COLLECTION).document(task.id).set(task).await()
        }

    override suspend fun delete(taskId: String) {
        firestore.collection(TASK_COLLECTION).document(taskId).delete().await()
    }

    companion object {
        private const val USER_ID_FIELD = "userId"
        private const val TASK_COLLECTION = "tickets"
        private const val SAVE_TASK_TRACE = "saveTask"
        private const val UPDATE_TASK_TRACE = "updateTask"
    }
}