package com.example.mvvmretrofit.data.repository

import android.content.Context
import com.example.mvvmretrofit.R
import com.example.mvvmretrofit.data.api.ApiService
import com.example.mvvmretrofit.data.api.ApiServiceImpl
import com.example.mvvmretrofit.data.api.OperationCallback
import com.example.mvvmretrofit.data.model.Posts
import com.example.mvvmretrofit.utils.isConnectedToInternet
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class PostsRepository @Inject constructor(@ApplicationContext val context: Context?, private val apiServiceImpl: ApiServiceImpl) {

    suspend fun getPosts(mListener: OperationCallback<List<Posts>>) = apiServiceImpl.getPosts().enqueue(object :
        Callback<List<Posts>> {
        override fun onResponse(
            call: Call<List<Posts>>,
            response: Response<List<Posts>>
        ) {
            if (isConnectedToInternet(context = context) == true) {
                mListener.onError( data = null, context?.getString(R.string.no_internet_connected) )
                return
            }
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