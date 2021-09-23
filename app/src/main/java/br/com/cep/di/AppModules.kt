package br.com.cep.di

import br.com.cep.network.di.NetworkModule
import org.koin.dsl.module

object AppModules {
    val appModules = module {
        single {
            NetworkModule.getService()
        }
//        viewModel {
//            RepositoriosViewModel(get())
//        }

    }
}