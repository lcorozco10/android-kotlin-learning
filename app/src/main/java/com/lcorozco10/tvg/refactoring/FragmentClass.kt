package com.lcorozco10.tvg.refactoring

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.lcorozco10.tvg.R

class FragmentClass : Fragment() {

    private var message: ISendMessage? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView:View =inflater!!.inflate(R.layout.fragment_layout,container)

        val messageText = rootView.findViewById<EditText>(R.id.messageTextEdit)
        val sendButton =  rootView.findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener {

            message?.sendMessage(messageText.text.toString())
            Toast.makeText(rootView.context, "Message : ${messageText.text}", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            message = context as ISendMessage
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        message = null
    }
}