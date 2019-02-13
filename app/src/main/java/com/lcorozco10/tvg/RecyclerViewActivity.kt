package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.lcorozco10.tvg.pojo.Names
import com.lcorozco10.tvg.pojo.Users
import com.lcorozco10.tvg.pojo.UsersAdapter

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var recycleView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        recycleView = findViewById(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<Users>()
        users.add(
                Users(1,"http://placehold.it/100x100",23,"Blue",
                        Names("Luis","Orozco"),"Core","lcorozco10@gmail.com"
                        ,"2578963","2018","Pera"))
        users.add(
                Users(2,"http://placehold.it/100x100",26,"Red",
                        Names("Henry","Orozco"),"House","henry@gmail.com"
                        ,"58967844","2019","Manzana"))

        var adapter = UsersAdapter(users)
        recycleView.adapter = adapter
    }
}
