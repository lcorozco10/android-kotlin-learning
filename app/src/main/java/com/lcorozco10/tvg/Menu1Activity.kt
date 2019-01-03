package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Menu1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when{
            item?.itemId == R.id.option1 -> {
                Toast.makeText(applicationContext,"Option 1",Toast.LENGTH_SHORT).show()
            }
            item?.itemId == R.id.option2 -> {
                Toast.makeText(applicationContext,"Option 2",Toast.LENGTH_SHORT).show()
            }
            item?.itemId == R.id.option3 -> {
                Toast.makeText(applicationContext,"Option 3",Toast.LENGTH_SHORT).show()
            }
            item?.itemId == R.id.subOption1 -> {
                Toast.makeText(applicationContext,"SubOption 1",Toast.LENGTH_SHORT).show()
            }
            item?.itemId == R.id.subOption2 -> {
                Toast.makeText(applicationContext,"SubOption 2",Toast.LENGTH_SHORT).show()
            }

        }


        return super.onOptionsItemSelected(item)
    }
}
