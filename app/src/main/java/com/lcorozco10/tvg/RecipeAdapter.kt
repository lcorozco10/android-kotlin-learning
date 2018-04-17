package com.lcorozco10.tvg

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class RecipeAdapter(private val context: Context,
                    private val dataSource: ArrayList<Recipe>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {

        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_recipe, parent, false)

        // Get title element
        val titleTextView = rowView.findViewById(R.id.titleTextView) as TextView

        // Get subtitle element
        val subtitleTextView = rowView.findViewById(R.id.subTitleTextView) as TextView

        // Get detail element
        val detailTextView = rowView.findViewById(R.id.detailTextView) as TextView

        // Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.imageViewIcon) as ImageView

        val recipe = getItem(position) as Recipe

        // 2
        titleTextView.text = recipe.title
        subtitleTextView.text = recipe.subTitle
        detailTextView.text = recipe.detail

        // 3
        Picasso.get().load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        return rowView
    }

    override fun getItem(position: Int): Any {

        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}

data class Recipe(var title:String, var subTitle:String, var detail:String, var imageUrl:String)