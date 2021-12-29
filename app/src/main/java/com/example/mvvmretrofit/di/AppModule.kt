package com.example.mvvmretrofit.di

import android.content.Context
import android.content.SharedPreferences
import com.example.mvvmretrofit.Constants.MY_SHARED_PREF
import com.example.mvvmretrofit.data.api.ApiService
import com.example.mvvmretrofit.data.api.RetrofitBuilder
import com.example.mvvmretrofit.utils.GsonHelper
import com.example.mvvmretrofit.utils.SharedPreferencesHelper
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()


    @Provides
    @Singleton
    fun providesApiUrl() = ""



    @Provides
    @Singleton
    fun customSharedPref(@ApplicationContext context: Context) : SharedPreferences {
        return   context.getSharedPreferences(
            MY_SHARED_PREF,
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideSharedPrefHelper(gson: Gson, sharedPreferences: SharedPreferences) = SharedPreferencesHelper(gson, sharedPreferences)

    @Provides
    @Singleton
    fun provideGsonHelper(gson:Gson?) = GsonHelper(gson)

//    @Provides
//    @Singleton
//    fun provideFirebaseAuth(): FirebaseAuth =  FirebaseAuth.getInstance()

}