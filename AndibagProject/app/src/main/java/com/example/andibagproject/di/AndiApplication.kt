package com.example.andibagproject.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndiApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndiApplication)

            modules(
                listOf(

                )
            )
        }
    }
}