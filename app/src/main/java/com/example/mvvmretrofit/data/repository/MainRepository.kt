package com.example.mvvmretrofit.data.repository

import com.example.mvvmretrofit.data.api.ApiHelper

//using a Repository pattern,linking our ApiHelper class by using a Repository class:
class MainRepository(private val apiHelper: ApiHelper) {

//    suspend fun getPosts() = apiHelper.getPosts()

}