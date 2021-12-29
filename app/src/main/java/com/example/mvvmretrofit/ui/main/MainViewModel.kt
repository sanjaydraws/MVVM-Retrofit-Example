package com.example.mvvmretrofit.ui.main

import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit.data.model.AllPosts
import com.example.mvvmretrofit.data.repository.UserPostsRepository
import com.example.mvvmretrofit.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val postsRepository:UserPostsRepository) : ViewModel() {

//    private val _postsResponse: MutableLiveData<List<Posts>?> = MutableLiveData()
//    val postsResponse: MutableLiveData<List<Posts>?> =_postsResponse


    private val _userPostResponse: MutableLiveData<Resource<AllPosts>> = MutableLiveData()
    val userPostResponse: MutableLiveData<Resource<AllPosts>> =_userPostResponse
    fun getPosts(){
        viewModelScope.launch {
            _userPostResponse.postValue(Resource.loading())
            val response = postsRepository.getPosts()
            _userPostResponse.postValue(response)

        }
    }

    /*
    fun getPosts() {
        viewModelScope.launch {
//            _postsResponse.postValue(Resource.loading())
            postsRepository.getPosts(object :OperationCallback<List<Posts>>{
                override fun onResponse(data: List<Posts>?) {
                    _postsResponse.postValue(data)
                }

                override fun onError(data: List<Posts>?, message: String?) {
                    // _postsResponse.postValue(Resource.error(data = null,message ="Error Occured"))
                    // _postsResponse.postValue(Resource.error(message = t.message.toString()))
                }


            })
        }
    }
    */

}




//override fun onResponse(call: Call<Resource<List<Posts>>>, response: Response<Resource<List<Posts>>>) {

//}
//override fun onFailure(call: Call<Resource<List<Posts>>>, t: Throwable) {
//    _postsResponse.postValue(Resource.error(data = null,message = t.message.toString()))
//
//}