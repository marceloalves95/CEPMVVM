package br.com.cep.di

import br.com.cep.network.repository.Repository
import br.com.cep.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {

    fun load(){
        loadKoinModules(appModule())
    }
    private fun appModule():Module{
        return module {
            single {
                Repository(get())
            }
            viewModel {
                MainActivityViewModel(get())
            }
        }
    }

}