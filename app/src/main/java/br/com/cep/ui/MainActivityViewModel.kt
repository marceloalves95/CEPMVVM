package br.com.cep.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cep.network.domain.CEP
import br.com.cep.network.domain.ErrorResponse
import br.com.cep.network.repository.Repository
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainActivityViewModel(private val repository: Repository):ViewModel() {

    private val _state = MutableStateFlow<CepState>(CepState.Empty)
    val state:StateFlow<CepState> = _state

    private fun emit(value:CepState){
        _state.value = value
    }

    fun getBuscarCEP(cep:String){

        viewModelScope.launch {
            try {
                emit(CepState.Loading(true))
                delay(1000)
                val response = repository.buscaEndereco(cep)
                with(response){
                    if (isSuccessful){
                        emit(CepState.Sucess(body()))
                    }else{
                        val json = errorBody()?.string()
                        val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
                        emit(CepState.Error(errorResponse.message))
                    }
                }
            }catch (exception: HttpException) {
                val json = exception.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
                emit(CepState.Error(errorResponse.message))
            }
            emit(CepState.Loading(false))
        }
    }

    sealed class CepState{
        class Sucess(val response:CEP?):CepState()
        class Loading(val isLoading:Boolean):CepState()
        class Error(val message:String):CepState()
        object Empty:CepState()
    }

}