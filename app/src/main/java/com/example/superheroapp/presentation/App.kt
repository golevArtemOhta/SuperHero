package com.example.superheroapp.presentation

import android.app.Application
import com.example.superheroapp.di.appModule
import com.example.superheroapp.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Reference Android context
            androidContext(this@App)
            // Load Modules
            modules(appModule, useCaseModule)
        }
    }
}

