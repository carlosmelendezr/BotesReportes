package com.carleodev.botesrep

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carleodev.botesrep.data.TicketNube
import com.carleodev.botesrep.data.TicketStorageService
import com.carleodev.botesrep.data.TicketStorageServiceImp
import com.carleodev.botesrep.ui.theme.BotesReportesTheme
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        val ticketStorageService: TicketStorageService by lazy {
            TicketStorageServiceImp(Firebase.firestore)
        }

        setContent {
            BotesReportesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android",
                        ticketStorageService=ticketStorageService)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,
             ticketStorageService: TicketStorageService) {


    ticketStorageService.firestore.collection("tickets")
        .whereEqualTo("tipopago",5).get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d("DATA", "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.w("DATA", "Error getting documents.", exception)
        }

}

