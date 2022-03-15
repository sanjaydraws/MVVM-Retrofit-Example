package com.example.mvvmretrofit.data.model

import androidx.annotation.Keep

@Keep
data class AllPosts (
    val allPosts:List<Posts>? = ArrayList()
)