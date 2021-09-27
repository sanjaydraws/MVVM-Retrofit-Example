package com.example.mvvmretrofit.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    val gson:Gson = GsonBuilder().serializeNulls().create() // it will show request keys with null
    private fun getRetrofit(): Retrofit {
        val builder:Retrofit.Builder =  Retrofit.Builder()
            .baseUrl(Apis.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

        //log http request & response with logging interceptor
        var httpClient:OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())
        var retrofit:Retrofit = builder.client(httpClient.build())
                                .build()
        return retrofit
    }


    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}