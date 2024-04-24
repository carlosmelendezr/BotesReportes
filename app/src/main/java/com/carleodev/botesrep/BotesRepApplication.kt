package com.carleodev.botesrep

import android.app.Application
import android.content.res.Resources

import com.carleodev.botesrep.data.AppContainer
import com.carleodev.botesrep.data.AppDataContainer


class BotesRepApplication: Application() {

    lateinit var container: AppContainer


    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)

    }


}