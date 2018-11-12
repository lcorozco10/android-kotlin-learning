package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText

class AutoComplete : AppCompatActivity() , View.OnClickListener {

    lateinit var autoComplete: AutoCompleteTextView
    lateinit var addEditText: EditText
    lateinit var addButton: Button
    lateinit var arrayAdapter: ArrayAdapter<String>
    var array: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)

        autoComplete = findViewById(R.id.autoCompleteTextView)
        addEditText = findViewById(R.id.addEditText)
        addButton = findViewById(R.id.addButton)

        // array.addAll (ArrayList<String>{"Luis", "Luisa", "Teresa", "Tomas", "Luisau"})

        addButton.setOnClickListener(this)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, array)
        autoComplete.threshold = 3
        autoComplete.setAdapter(arrayAdapter)

    }

    override fun onClick(p0: View?) {
        when {
            p0?.id == R.id.addButton -> {
                if (addEditText.text != null)
                {

                    array.add(addEditText.text.toString())
                    Log.d("Array",array.last())
                    arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, array)
                    autoComplete.setAdapter(arrayAdapter)
                }
            }
        }

    }
}
