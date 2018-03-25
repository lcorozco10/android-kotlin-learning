package com.lcorozco10.tvg

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_principal.*

class HomeActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var textInfo:TextView = findViewById(R.id.textViewInfo)
        var edtUserName:EditText =  findViewById(R.id.edtUserName)
        var edtPassword:EditText =  findViewById(R.id.edtPassword)
        var btnLogin:Button = findViewById(R.id.btnLogin)
        textInfo.text = "Welcome to TVG app"



        btnLogin.setOnClickListener{
            if (edtUserName.text.toString() == "lcorozco" && edtPassword.text.toString() == "123456" ) {
                val intent = Intent( applicationContext, PrincipalActivity::class.java)
                startActivity(intent);
            }else{
                textInfo.text = "UserName ${edtUserName.text} is invalid"
            }
        }
    }
}
