package br.com.cep.network.di

import br.com.cep.network.api.ApiCEP
import br.com.cep.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    private fun criarHttpClient():OkHttpClient{

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(40,TimeUnit.SECONDS)
            .writeTimeout(40,TimeUnit.SECONDS)
            .build()
    }

    fun getService(): ApiCEP {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(criarHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCEP::class.java)

    }



}