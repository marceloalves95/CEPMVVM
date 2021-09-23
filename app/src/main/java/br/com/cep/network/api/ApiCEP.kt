package br.com.cep.network.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCEP {

    @GET("{CEP}")
    suspend fun buscaEndereco(@Path("CEP") cep:String)

}