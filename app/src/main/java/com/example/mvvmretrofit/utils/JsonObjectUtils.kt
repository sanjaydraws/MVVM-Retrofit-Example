package com.example.mvvmretrofit.utils

import org.json.JSONObject

fun hashmapToJsonObject(params: HashMap<String, String?>? = null) = JSONObject().also {
    params?.forEach { entry ->
        it.put(entry.key, entry.value)
    }
}