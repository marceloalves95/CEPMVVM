package br.com.cep.network.domain

data class ErrorResponse(
    val code: String,
    val message: String,
    val status: Int
)