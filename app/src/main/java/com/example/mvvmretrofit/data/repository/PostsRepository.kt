package com.example.mvvmretrofit.data.repository

import com.example.mvvmretrofit.data.api.ApiHelper
import com.example.mvvmretrofit.data.api.ApiService


class PostsRepository(private val apiService: ApiService) {

    suspend fun getPosts() = apiService.getPosts()

}