package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.lcorozco10.tvg.pojo.Users
import com.lcorozco10.tvg.pojo.UsersAdapter
import com.lcorozco10.tvg.serveces.SearchRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var recycleView: RecyclerView
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        recycleView = findViewById(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val repository = SearchRepositoryProvider.SearchRepository()

        compositeDisposable.add(
                repository.GetUsers("test")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            val data: ArrayList<Users> = ArrayList(result)
                            val adapter = UsersAdapter(array = data)
                            recycleView.adapter = adapter
                            Log.d("Result", "There are ${data.first().picture} Java developers in Lagos")
                        }, { error ->
                            Log.d("Result", "There are ${error.message} Java developers in Lagos")
                            error.printStackTrace()
                        }))
    }
}
