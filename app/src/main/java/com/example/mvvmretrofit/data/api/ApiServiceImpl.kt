package com.example.mvvmretrofit.data.api

import com.example.mvvmretrofit.data.model.Posts
import retrofit2.Call
import javax.inject.Inject


// help with api service class
class ApiServiceImpl @Inject constructor(private val apiService:ApiService) {

    suspend fun getPosts(): Call<List<Posts>> = apiService.getPosts()


}


