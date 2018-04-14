package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var listview:ListView
    private var items = arrayOf("Managua","Masaya","Leon","Rivas","Granada","Chinandega","Carazo","Esteli")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listview = findViewById(R.id.listViewTest)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listview.adapter = adapter


        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Position Clicked: ${position}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(p0: View?) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
