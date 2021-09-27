package com.example.mvvmretrofit.ui.main

import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit.data.api.OperationCallback
import com.example.mvvmretrofit.data.api.RetrofitBuilder
import com.example.mvvmretrofit.data.model.Posts
import com.example.mvvmretrofit.data.repository.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel() : ViewModel() {

    private val postsRepository: PostsRepository = PostsRepository(RetrofitBuilder.apiService)
    private val _postsResponse:MutableLiveData<List<Posts>> = MutableLiveData()
    val postsResponse:MutableLiveData<List<Posts>> =_postsResponse


    fun getPosts() {
        viewModelScope.launch {
//            _postsResponse.postValue(Resource.loading())
            postsRepository.getPosts(object :OperationCallback<List<Posts>>{
                override fun onResponse(data: List<Posts>?) {
                    _postsResponse.postValue(data)
                }

                override fun onError(message: String?) {
                    // _postsResponse.postValue(Resource.error(data = null,message ="Error Occured"))
                    // _postsResponse.postValue(Resource.error(message = t.message.toString()))
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