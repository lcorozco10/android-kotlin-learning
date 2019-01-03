package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lcorozco10.tvg.refactoring.FragmentClass2
import com.lcorozco10.tvg.refactoring.ISendMessage

class FragmentActivity : AppCompatActivity(), ISendMessage {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }

    override fun sendMessage(message: String) {
        Log.d("text", message)
        var f2:FragmentClass2 = fragmentManager.findFragmentById(R.id.myFragment2) as FragmentClass2
        f2.getMessage(message)
    }
}
