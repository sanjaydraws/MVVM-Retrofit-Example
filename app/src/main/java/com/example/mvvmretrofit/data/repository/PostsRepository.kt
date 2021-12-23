package com.example.mvvmretrofit.data.repository

import com.example.mvvmretrofit.data.api.ApiService
import com.example.mvvmretrofit.data.api.ApiServiceImpl
import com.example.mvvmretrofit.data.api.OperationCallback
import com.example.mvvmretrofit.data.model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class PostsRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    suspend fun getPosts(mListener: OperationCallback<List<Posts>>) = apiServiceImpl.getPosts().enqueue(object :
        Callback<List<Posts>> {
        override fun onResponse(
            call: Call<List<Posts>>,
            response: Response<List<Posts>>
        ) {
            if (!response.isSuccessful) {
                mListener.onError(data = response.body(), response.message())
                return;
            }
            mListener.onResponse(data = response.body())
        }
        override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
            mListener.onError(data = null, t.message)
        }
    })



}