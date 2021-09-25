package com.example.mvvmretrofit.ui.main

import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit.data.api.RetrofitBuilder
import com.example.mvvmretrofit.data.model.AllPosts
import com.example.mvvmretrofit.data.model.Posts
import com.example.mvvmretrofit.data.repository.MainRepository
import com.example.mvvmretrofit.data.repository.PostsRepository
import com.example.mvvmretrofit.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel() : ViewModel() {

    private val postsRepository: PostsRepository = PostsRepository(RetrofitBuilder.apiService)
    private val _postsResponse:MutableLiveData<Resource<List<Posts>>> = MutableLiveData()
    val postsResponse:MutableLiveData<Resource<List<Posts>>> =_postsResponse


    fun getPosts() {
        viewModelScope.launch {
            _postsResponse.postValue(Resource.loading())
            val call:Call<Resource<List<Posts>>> = postsRepository.getPosts()
            call.enqueue(object :Callback<Resource<List<Posts>>>{
                override fun onResponse(
                    call: Call<Resource<List<Posts>>>,
                    response: Response<Resource<List<Posts>>>
                ) {
                    if (!response.isSuccessful) {
                        _postsResponse.postValue(Resource.error(data = null,message ="Error Occured"))
                        return;
                    }
                    _postsResponse.postValue(response.body())
                }
                override fun onFailure(call: Call<Resource<List<Posts>>>, t: Throwable) {
                    _postsResponse.postValue(Resource.error(message = t.message.toString()))
                }
            })
        }
    }

}




//override fun onResponse(call: Call<Resource<List<Posts>>>, response: Response<Resource<List<Posts>>>) {

//}
//override fun onFailure(call: Call<Resource<List<Posts>>>, t: Throwable) {
//    _postsResponse.postValue(Resource.error(data = null,message = t.message.toString()))
//
//}