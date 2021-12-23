package com.example.mvvmretrofit.data.api

/**
 * @author Sanjay Prajapat
 * time: 27-09-2021 0n 11:30 PM
 */

interface OperationCallback<T> {
    fun onResponse(data:T?)
    fun onError(data:T?,message:String?)
}