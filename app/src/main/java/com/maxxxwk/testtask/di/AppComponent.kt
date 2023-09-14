package com.maxxxwk.testtask.di

import android.content.Context
import com.maxxxwk.testtask.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DispatchersModule::class,
        DependenciesModule::class,
        NetworkModule::class,
        LocalPreferencesModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}
