package com.example.mvvmretrofit.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Sanjay Prajapat
 * time : 27-09-2021 On 11:55 PM
 * */



object RetrofitBuilder {


    val gson:Gson = GsonBuilder().serializeNulls().create() // it will show request keys with null
    private fun getRetrofit(): Retrofit {
        val builder:Retrofit.Builder =  Retrofit.Builder()
            .baseUrl(Apis.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

        //log http request & response with logging interceptor
        var httpClient:OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(object :Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalRequest:Request = chain.request()
                val newRequest:Request = originalRequest.newBuilder()
                    .addHeader("Interceptor-Header","xyz")
                    .addHeader("Authorization", "h38278sqjsgkjq82u,ebqmxbausiwgey2iemwbsliwhrowirh bms")//login token
                    .addHeader("Language","en")
                    .build()
                return chain.proceed(newRequest)
            }
        }).addInterceptor(interceptor())

        var retrofit:Retrofit = builder.client(httpClient.build()).build()
        return retrofit
    }


    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}