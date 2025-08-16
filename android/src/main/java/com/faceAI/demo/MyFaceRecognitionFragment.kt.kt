package com.faceAI.demo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.graphics.Color
import androidx.fragment.app.Fragment
import android.widget.FrameLayout

class MyFaceRecognitionFragment : Fragment() {

    private val TAG = "FaceRecognitionDebug"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "Fragment: onCreateView CALLED")
        // 创建一个简单的 TextView
    val textView = TextView(requireContext()).apply {
    text = "Hello From Native Fragment!"
    textSize = 20f
    setTextColor(Color.YELLOW)
    setBackgroundColor(Color.parseColor("#3498db"))
    gravity = android.view.Gravity.CENTER
    }
    return textView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Fragment: onViewCreated CALLED")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Fragment: onResume CALLED")
    }
}