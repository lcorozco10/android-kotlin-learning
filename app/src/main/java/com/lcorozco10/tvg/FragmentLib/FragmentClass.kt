package com.lcorozco10.tvg.FragmentLib

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.lcorozco10.tvg.R

class FragmentClass : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var rootView:View =inflater!!.inflate(R.layout.fragment_layout,container)

        var messageText = rootView.findViewById<EditText>(R.id.messageTextEdit)
        var sendButton =  rootView.findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener {
            Toast.makeText(rootView.context, "Message : ${messageText.text.toString()}", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}