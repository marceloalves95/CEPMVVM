package br.com.cep.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cep.network.domain.CEP
import br.com.cep.network.domain.ErrorResponse
import br.com.cep.network.repository.Repository
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainActivityViewModel(private val repository: Repository): ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    private fun emit(value: State) {
        _state.value = value
    }

    fun getBusca(cep: String) {
        viewModelScope.launch {
            try {
                emit(State.Loading(true))
                delay(1000)
                val response = repository.buscaEndereco(cep)
                with(response) {
                    if (isSuccessful) {
                        emit(State.Sucess(body()))
                    } else {
                        val json = errorBody()?.charStream()
                        val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
                        emit(State.Error(errorResponse.message))
                    }
                }
            } catch (exception: HttpException) {
                val json = exception.response()?.errorBody()?.charStream()
                val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
                emit(State.Error(errorResponse.message))
            }
            emit(State.Loading(false))
        }
    }

    sealed class State {
        class Loading(val isLoading: Boolean) : State()
        class Sucess(val response: CEP?) : State()
        class Error(val message: String) : State()
    }

}

