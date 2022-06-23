package com.example.andibagproject.di

import android.app.Application
import com.example.andibagproject.di.module.*
import com.example.andibagproject.handler.ExceptionHandler
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndiApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndiApplication)

            modules(
                listOf(
                    loginModule,
                    makeIdModule,
                    makeGalleryModule,
                    seeGalleryModule,
                    addFriendModule,
                    loadFriendModule,
                    commentModule
                )
            )
        }
        setCrashHandler()
    }
    private fun setCrashHandler(){
        val crashlyticsExceptionHandler = Thread.getDefaultUncaughtExceptionHandler() ?: return
        Thread.setDefaultUncaughtExceptionHandler(
            ExceptionHandler(
                this,
                crashlyticsExceptionHandler
            )
        )
    }
}