package com.example.mvvmretrofit.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log


/**
 *  add permission in manifest
 * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 * <uses-permission android:name="android.permission.INTERNET" />
 *
 * */



/**
 * If network connectivity is available, will return true
 *
 * @param context the current context
 * @return boolean true if a network connection is available
 */
fun isConnectedToInternet(context: Context?): Boolean? {
    val connectivity = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    // get network info for all of the data interfaces (e.g. WiFi, 3G, LTE, etc.)
    val info = connectivity?.allNetworkInfo
    // make sure that there is at least one interface to test against
    info?.indices?.let {
        for (i in info.indices) {
            // check this interface for a connected state
            if (info[i]?.state == NetworkInfo.State.CONNECTED) {
                Log.d("NetworkCheck", "isNetworkAvailable: Yes")
                return true
            }
        }
    }
    return false
}