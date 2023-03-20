package com.maxxxwk.testtask

import android.app.Application
import com.maxxxwk.testtask.di.AppComponent
import com.maxxxwk.testtask.di.DaggerAppComponent

class App : Application() {
    val component: AppComponent by lazy { DaggerAppComponent.factory().create(this) }
}
