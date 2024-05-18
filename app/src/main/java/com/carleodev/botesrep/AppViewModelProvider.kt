package com.carleodev.botesrep

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.carleodev.botesrep.ui.*
import com.carleodev.botesrep.ui.home.SplashViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            SplashViewModel(
                this.createSavedStateHandle()
              
            )
        }

        initializer {
            ReporteDiaViewModel(
                this.createSavedStateHandle(),
                botesRepApplication().container.ticketStorageService,
                botesRepApplication()

            )
        }

    }

    fun CreationExtras.botesRepApplication(): BotesRepApplication =
        (this[AndroidViewModelFactory.APPLICATION_KEY] as BotesRepApplication)
}