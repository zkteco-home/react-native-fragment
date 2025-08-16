// 文件路径: android/src/main/java/com/reactnativefacerecognition/FaceRecognitionFragmentContainer.kt
package com.faceAI.demo

import android.content.Context
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import android.widget.TextView
import android.graphics.Color

class FaceRecognitionFragmentContainer(context: Context) : FrameLayout(context) {

    private val TAG = "FaceRecognitionDebug"
    // 标志位，确保 Fragment 只被添加一次
    private var isFragmentAdded = false
    private var isMounted = false
 
    init {
        id = generateViewId()
        Log.d(TAG, "Container: init CALLED, ID set to $id")
    }

    // onAttachedToWindow 中不再做任何事，因为它太早了
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "Container: onAttachedToWindow CALLED")
    if (!isMounted) {
      // Notifies JS view that the native view is now available
      isMounted = true
     // invokeOnViewReady()
    }


    }

    /**
        This is the final solution.
        We will execute the Fragment setup only when onLayout brings us valid width and height for the first time.
        This ensures that when the Fragment is created, its parent container already has exact, non-zero dimensions.
     */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        val width = right - left
        val height = bottom - top

        // When the container first obtains a valid size
        if (width > 0 && height > 0 && !isFragmentAdded) {
            Log.d(TAG, "Container: Received initial size ($width, $height). NOW setting up fragment.")
            //
            isFragmentAdded = true
            // It is here, at this moment, that we proceed to add the Fragment.
           // setupFragment()

            // Completely bypass the Fragment and directly create a TextView
            val textView = TextView(context).apply {
                text = "Direct TextView Test"
                textSize = 20f
                setTextColor(Color.WHITE)
                setBackgroundColor(Color.parseColor("#e74c3c")) // 
                gravity = android.view.Gravity.CENTER
            }
            
            
            this.addView(textView)


        }
    }

    private fun setupFragment() {
        Log.d(TAG, "Container: setupFragment CALLED")
        val fragmentActivity = findFragmentActivity()
        if (fragmentActivity == null) {
            Log.e(TAG, "FATAL: Could not find FragmentActivity.")
            return
        }

        val fragmentManager = fragmentActivity.supportFragmentManager
        if (fragmentManager.findFragmentById(id) == null) {
            Log.d(TAG, "Container: Creating and adding a new fragment.")
            fragmentManager.beginTransaction()
                .add(id, MyFaceRecognitionFragment::class.java, null)
                .commitNow()
        }
 }

    private fun findFragmentActivity(): FragmentActivity? {
        var currentContext = context
        while (currentContext is android.content.ContextWrapper) {
            if (currentContext is FragmentActivity) return currentContext
            currentContext = currentContext.baseContext
        }
        return null
    }
}