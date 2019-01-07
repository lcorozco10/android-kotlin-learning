package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar


class TabActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var tab: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tab = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.pager)

        viewPager.adapter = PagerAdapterManager(supportFragmentManager)
        tab.setupWithViewPager(viewPager)
    }
}

class PagerAdapterManager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return FragmentA()

            }
            1 -> {
                return FragmentB()
            }
            2 -> {
                return FragmentC()
            }
        }

        return FragmentC()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {

        when (position) {
            0 -> {
                return "Tab 1"

            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }

        return "Tab 3"
    }

}
