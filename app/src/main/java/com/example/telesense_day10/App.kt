package com.example.telesense_day10

import android.app.Application
import io.philippeboisney.archapp.di.appComponent
import org.koin.android.ext.android.startKoin

open class App : Application(){
    override fun onCreate() {
        super.onCreate()

    }
    open fun configureDi() =
        startKoin(this, provideComponent())

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}