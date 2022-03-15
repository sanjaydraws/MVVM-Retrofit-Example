package com.example.mvvmretrofit.data.repository

import android.content.Context
import com.example.mvvmretrofit.R
import com.example.mvvmretrofit.data.api.ApiService
import com.example.mvvmretrofit.data.model.AllPosts
import com.example.mvvmretrofit.data.model.Posts
import com.example.mvvmretrofit.utils.GsonHelper
import com.example.mvvmretrofit.utils.Resource
import com.example.mvvmretrofit.utils.isConnectedToInternet
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class UserPostsRepository @Inject constructor(@ApplicationContext val context: Context?, private val apiService: ApiService
                       ,private val gson: GsonHelper) {

    val params: HashMap<String, String?> by lazy {
        HashMap<String, String?>()
    }

//    suspend fun getPosts(
//    ): Resource<AllPosts> {
//
//        if (isConnectedToInternet(context = context) != true) {
//            return Resource.error(data = null, context?.getString(R.string.no_internet_connected))
//        }
//        try {
//            val response = apiService.getPosts()
//            if (response?.isSuccessful == false) {
//                return Resource.error(
//                    data = null,
//                    context?.getString(R.string.default_error_message)
//                )
//            }
//            if (response?.body()?.status == 200) {
//                val posts  = Gson().fromJson(response.body()?.data, AllPosts::class.java)
//                return Resource.success(data = posts)
//            } else if (response?.body()?.status == 400) {
//                return Resource.error(message = response.body()?.message)
//            }
//            return Resource.error( message = response?.body()?.message?: context?.getString(R.string.default_error_message))
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return Resource.error(data = null, context?.getString(R.string.default_error_message))
//        }
//    }


    suspend fun getPosts(
    ): Resource<AllPosts> {

        if (isConnectedToInternet(context = context) != true) {
            return Resource.error(data = null, context?.getString(R.string.no_internet_connected))
        }
        try {
            val response = apiService.getPosts()
            if (response?.isSuccessful == false) {
                return Resource.error(
                    data = null,
                    context?.getString(R.string.default_error_message)
                )
            }
            if (response?.code() == 200) {
//                val posts  = gson.convertFromJson(response.body().toString(),AllPosts::class.java)
                return Resource.success(data = AllPosts(response.body()))
            } else if (response?.code() == 400) {
                return Resource.error(message = response.message()?:context?.getString(R.string.default_error_message))
            }
            return Resource.error( message = response?.message()?: context?.getString(R.string.default_error_message))
        } catch (e: Exception) {
            e.printStackTrace()
            return Resource.error(data = null, context?.getString(R.string.default_error_message))
        }
    }
}


