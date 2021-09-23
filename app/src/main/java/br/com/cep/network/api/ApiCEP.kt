package br.com.cep.network.api

import br.com.cep.network.domain.CEP
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCEP {

    @GET("{CEP}")
    suspend fun buscaEndereco(@Path("CEP") cep:String):Response<CEP>

}