package com.example.mvvmretrofit.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Posts (
    @SerializedName("userId")
    val userId:Int?=null,
    @SerializedName("id")
    val id:Int?=null,
    @SerializedName("title")
    val title:String?=null,
    @SerializedName("body")
    val description:String?=null,
)