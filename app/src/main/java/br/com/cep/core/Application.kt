package br.com.cep.core

import android.app.Application
import br.com.cep.di.AppModule
import br.com.cep.network.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
        }
        AppModule.load()
        NetworkModule.load()

    }
}