package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class RatingBarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ratingBar: RatingBar
    private lateinit var valueRatingText: TextView
    private lateinit var sendRatingButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        ratingBar = findViewById(R.id.myRatingBar)
        valueRatingText = findViewById(R.id.ratingValue)
        sendRatingButton = findViewById(R.id.sendRating)
        sendRatingButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when {
            p0?.id == R.id.sendRating -> {
                valueRatingText.text = ratingBar.rating.toString()
            }
        }
    }
}
