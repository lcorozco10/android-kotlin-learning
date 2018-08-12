package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class RelativeLayoutExample : AppCompatActivity(), View.OnClickListener {

    private lateinit var counterValueText: TextView
    private lateinit var increaseButton: Button
    private lateinit var decreaseButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout_example)

        counterValueText = findViewById(R.id.CounterValue)
        increaseButton = findViewById(R.id.IncreaseButton)
        decreaseButton = findViewById(R.id.DecreaseButton)
        resetButton = findViewById(R.id.ResetButton)
        counterValueText.text = 0.toString()

        increaseButton.setOnClickListener(this)
        decreaseButton.setOnClickListener(this)
        resetButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when {
            p0?.id == R.id.ResetButton->{
                counterValueText.text = 0.toString()
            }
            p0?.id ==R.id.IncreaseButton->{

                var currentValue = counterValueText?.text?.toString()?.toInt()?:0
                counterValueText.text = (++currentValue).toString()
            }
            p0?.id ==R.id.DecreaseButton->{

                var currentValue = counterValueText?.text?.toString()?.toInt()?:0
                counterValueText.text = (--currentValue).toString()
            }
        }
    }
}
