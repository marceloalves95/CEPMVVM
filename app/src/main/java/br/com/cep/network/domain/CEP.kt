package br.com.cep.network.domain

data class CEP(
    val address: String,
    val address_name: String,
    val address_type: String,
    val cep: String,
    val city: String,
    val city_ibge: String,
    val ddd: String,
    val district: String,
    val lat: String,
    val lng: String,
    val state: String
)