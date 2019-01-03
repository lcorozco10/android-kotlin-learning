package com.lcorozco10.tvg.refactoring

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lcorozco10.tvg.R

class FragmentClass2 : Fragment()  {

    private lateinit var rootView: View
    lateinit var textView:TextView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater!!.inflate(R.layout.fragment2_layout,container)

        textView = rootView.findViewById(R.id.outTextView)
        textView.text = "Nada"

        return  rootView
    }

    fun getMessage(message:String){
        textView.text = message
    }
}