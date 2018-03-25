package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var textInfo:TextView = findViewById(R.id.textViewInfo)
        textInfo.setText("Hola Developer")

        var btnLogin:Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            textInfo.setText("Clicked login button")
        }
    }
}
