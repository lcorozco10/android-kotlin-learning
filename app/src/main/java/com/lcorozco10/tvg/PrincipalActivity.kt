package com.lcorozco10.tvg

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PrincipalActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var btnBack:Button
    private lateinit var btnSend:Button
    private lateinit var edtSomeText:EditText
    private lateinit var textValue:TextView
    private lateinit var txtTitle:TextView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        btnBack = findViewById(R.id.btnBack)
        btnSend = findViewById(R.id.btnSend)
        edtSomeText = findViewById(R.id.edtSomeText)
        textValue = findViewById(R.id.txtValue)
        txtTitle = findViewById(R.id.txtTitle)

        var extras = intent.extras
        if (extras!= null){
            var user = extras["Username"]
            txtTitle.text = "${txtTitle.text} $user"
        }

        textValue.text = "Nada por ahora"

        btnSend.setOnClickListener(this)
        btnBack.setOnClickListener(this)

    }


    override fun onClick(p0: View?) {
        when {
            p0?.id ==R.id.btnBack -> {
                val intent = Intent( this, HomeActivity::class.java)
                startActivity(intent)
            }
            p0?.id == R.id.btnSend -> textValue.text = edtSomeText.text.toString()
            else -> textValue.text = "Nada"
        }

        Log.d("click", "Test")
    }
}
