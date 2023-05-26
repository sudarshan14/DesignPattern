package com.amlavati.designpatterns.commonutil

import android.util.Log
import com.amlavati.designpatterns.BuildConfig


const val TAG = "HandsOnApplication"

fun printDebugLog(tag: String = TAG, message: String) {
    if (BuildConfig.DEBUG)
        Log.d(tag, message)
}


