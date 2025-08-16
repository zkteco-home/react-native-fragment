package com.faceAI.demo


import android.util.Log
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp


class FaceRecognitionViewManager : SimpleViewManager<FaceRecognitionFragmentContainer>() {
    private val TAG = "FaceRecognitionDebug"

    override fun getName() = "FaceRecognitionView"

    override fun createViewInstance(reactContext: ThemedReactContext): FaceRecognitionFragmentContainer {
        Log.d(TAG, "ViewManager: createViewInstance CALLED for component ${getName()}")
        return FaceRecognitionFragmentContainer(reactContext)
    }

    @ReactProp(name = "color")
    fun setColor(view: FaceRecognitionFragmentContainer, color: String?) {
        // We are not using this, but it's good to keep for future props
    }
}