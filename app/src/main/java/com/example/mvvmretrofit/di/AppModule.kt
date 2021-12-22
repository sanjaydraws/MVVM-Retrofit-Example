package com.example.mvvmretrofit.di

import com.example.mvvmretrofit.data.api.ApiService
import com.example.mvvmretrofit.data.api.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesApiUrl() = "https://jsonplaceholder.typicode.com/"


}