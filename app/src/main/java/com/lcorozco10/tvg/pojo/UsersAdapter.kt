package com.lcorozco10.tvg.pojo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lcorozco10.tvg.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*


class UsersAdapter(private val array: ArrayList<Users>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.name?.text = "${array[position].names.first} ${array[position].names.last}"
        holder?.age?.text = array[position].age.toString()
        holder?.eyeColor?.text = array[position].eyeColor
        holder?.company?.text = array[position].company
        holder?.phone?.text = array[position].phone
        holder?.registered?.text = array[position].registered
        Picasso.get().load(array[position].picture).into(holder?.picture)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val picture = view.pictureImageView!!
        val name = view.nameTextView!!
        val age = view.ageTextView!!
        val eyeColor = view.eyeColorTextView!!
        val company = view.companyTextView!!
        val phone = view.phoneTextView!!
        val registered = view.registeredTextView!!
    }
}