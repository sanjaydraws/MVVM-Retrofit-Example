package com.example.mvvmretrofit.data.api

import com.example.mvvmretrofit.data.model.AllPosts
import com.example.mvvmretrofit.data.model.Posts
import com.example.mvvmretrofit.utils.Resource
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
     fun getPosts(): Call<List<Posts>>

}