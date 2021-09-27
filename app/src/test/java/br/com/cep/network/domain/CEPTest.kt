package br.com.cep.network.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CEPTest{

    //Arrange(Planejar)
    @MockK
    lateinit var numeroCep:String

    @MockK
    lateinit var cep: CEP

//    @Before
//    fun setUp() = MockKAnnotations.init(this)

    //Act (Agir)
    @Test
    fun `testar o numero do Cep`(){

        //Assert(Afirmar)
        numeroCep = "03967000"
        assertEquals("03967000", numeroCep)

    }

    @Test
    fun testedeCep(){
        cep = CEP("Avenida João Velho do Rego","João Velho do Rego","Avenida","03967000","São Paulo","3550308","11","Parque Colonial","-23.6026806","-46.4750838","SP")
        assertEquals("Correto","Avenida João Velho do Rego",cep.address)
    }

}