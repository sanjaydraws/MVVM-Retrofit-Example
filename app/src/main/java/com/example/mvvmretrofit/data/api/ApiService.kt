package com.example.mvvmretrofit.data.api

import com.example.mvvmretrofit.data.model.AllPosts
import com.example.mvvmretrofit.data.model.BaseApiModel
import com.example.mvvmretrofit.data.model.Posts
import com.example.mvvmretrofit.utils.Resource
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
     suspend fun getPosts(): Response<BaseApiModel>?

}