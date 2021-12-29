package com.example.mvvmretrofit.utils

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


/**
 * Created By : Sanjay Prajapat
 * Time : 24/09/2021 on 12:23 AM
 *
 * */
class GsonHelper ( val gson: Gson?){

    /**
     * convert object to json
     * @param object type
     * @return String json
     * */
    fun <T> convertToJson( t:T ): String? = gson?.toJson(t)

    /**
     * convert json to object
     * @param String json
     * @param T class type
     * @return String json
     * */
    fun <T> convertFromJson(json:String?, t:Class<T>):T? = gson?.fromJson(json,t)


    /*
    * {"user1":{"address":{"firstAddress":"Green Street","secondAddress":"USA"},"age":23,"firstName":"Justin","lastName":" Bieber","numbers":["2345678","9039023"]},"i1":23}
    * */
    fun <T> mapToJsonStr(map: Map<String?, T>?): String? =  gson?.toJson(map)



    /**
     * convert list of json string to Array List
     * */
    inline fun <reified T> convertToArrayList(listJson:String?): List<T>? {
        val tokenType: Type = object : TypeToken<ArrayList<T>>() {}.type
        return gson?.fromJson(listJson, tokenType)
    }



    inline fun <reified T : Any> fromJsonElement(jsonElement: JsonElement?): T? = gson?.fromJson(jsonElement, T::class.java)



}