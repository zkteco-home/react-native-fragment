package com.faceAI.demo

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import com.facebook.react.bridge.*
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.io.ByteArrayOutputStream
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableArray
import android.util.Base64
import com.facebook.react.modules.core.DeviceEventManagerModule
import androidx.core.content.ContextCompat
import android.content.Intent

import org.json.JSONObject

class FaceAISDKModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  companion object {
    public var faceCameraViewManager: FaceRecognitionViewManager? = null
  }


  override fun getName(): String = "FaceAISDK"


}
