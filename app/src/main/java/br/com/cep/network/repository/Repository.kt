package br.com.cep.network.repository

import br.com.cep.network.api.ApiCEP

class Repository(private val apiCEP: ApiCEP) {

    suspend fun buscaEndereco(cep:String) = apiCEP.buscaEndereco(cep)

}