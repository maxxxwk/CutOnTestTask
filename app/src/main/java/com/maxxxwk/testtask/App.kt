package com.maxxxwk.testtask

import android.app.Application
import com.maxxxwk.testtask.di.dependenciesModule
import com.maxxxwk.testtask.di.dispatchersModule
import com.maxxxwk.testtask.di.localPreferencesModule
import com.maxxxwk.testtask.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                dispatchersModule,
                dependenciesModule,
                localPreferencesModule,
                networkModule
            )
        }
    }
}
