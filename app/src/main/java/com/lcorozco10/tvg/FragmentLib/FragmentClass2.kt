package com.lcorozco10.tvg.FragmentLib

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lcorozco10.tvg.R

class FragmentClass2 : Fragment()  {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment2_layout,container)
    }
}