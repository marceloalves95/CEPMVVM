package br.com.cep.network.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CEPTest{

    @MockK
    lateinit var cep: CEP

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun testedeCep(){
        cep = CEP("Avenida João Velho do Rego","João Velho do Rego","Avenida","03967000","São Paulo","3550308","11","Parque Colonial","-23.6026806","-46.4750838","SP")
        println(cep.address)
    }
}