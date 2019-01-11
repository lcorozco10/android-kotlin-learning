package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView

class DatePickerActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var datePicker: DatePicker
    lateinit var txtViewDate: TextView
    lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        datePicker = findViewById(R.id.dtPicker)
        txtViewDate = findViewById(R.id.txtViewDate)
        sendButton = findViewById(R.id.sendButton)
        sendButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when {
            p0?.id == R.id.sendButton -> {
                txtViewDate.text =   "${datePicker.dayOfMonth}-${datePicker.month}-${datePicker.year}"
            }
        }
    }
}
