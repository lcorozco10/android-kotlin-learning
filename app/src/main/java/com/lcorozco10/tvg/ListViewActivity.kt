package com.lcorozco10.tvg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listview = findViewById(R.id.listViewTest)

        val adapter = RecipeAdapter(this,
                arrayListOf(
                        Recipe("Managua", "Lorem Ipsum is simply dummy", "Detail", "https://media-cdn.tripadvisor.com/media/photo-s/08/26/88/d7/managua-department.jpg"),
                        Recipe("Masaya", "Lorem Ipsum is simply dummy", "Detail", "https://www.poderjudicial.gob.ni/pjupload/tam_my/baner/01_der_magistrados.jpg"),
                        Recipe("Granada", "Lorem Ipsum is simply dummy", "Detail", "https://media-cdn.tripadvisor.com/media/photo-s/01/e5/da/93/plaza-de-la-independencia.jpg"),
                        Recipe("Carazo", "Lorem Ipsum is simply dummy", "Detail", "https://i.pinimg.com/originals/d8/a5/53/d8a553441e67402ed1fc542f6a8fa4d7.jpg"),
                        Recipe("Rivas", "Lorem Ipsum is simply dummy", "Detail", "http://www.lavozdelsandinismo.com/wp-estaticos/2017/05/Rivas-Nicaragua.jpg"),
                        Recipe("León", "Lorem Ipsum is simply dummy", "Detail", "https://farm2.staticflickr.com/1562/25164662984_6a6a3307af_c.jpg"),
                        Recipe("Chinandega", "Lorem Ipsum is simply dummy", "Detail", "https://endimages.s3.amazonaws.com/photos/7a742a4a7a4d11e7b98e0eb04a1bba78.jpg"),
                        Recipe("Estelí", "Lorem Ipsum is simply dummy", "Detail", "http://www.bacanalnica.com/wp-content/uploads/media/k2/items/cache/f78ce63d5d51138de75a49f7b637cc6b_L.jpg"),
                        Recipe("Matagalpa", "Lorem Ipsum is simply dummy", "Detail", "https://cache-graphicslib.viator.com/graphicslib/thumbs674x446/9881/SITours/green-mountains-of-matagalpa-and-coffee-tour-in-managua-208947.jpg"),
                        Recipe("Jinotega", "Lorem Ipsum is simply dummy", "Detail", "https://www.visitanicaragua.com/wp-content/uploads/photo-gallery/Vista%20Jinotega%20Visitnicaragua.jpg"),
                        Recipe("Boaco", "Lorem Ipsum is simply dummy", "Detail", "http://www.lavozdelsandinismo.com/wp-estaticos/2011/10/01/la-poblacion-de-boaco-nicaragua.jpg")
                )
        )

        listview.adapter = adapter

        listview.setOnItemClickListener { _, _, position, _ ->

            val recipe = adapter.getItem(position) as Recipe

            Toast.makeText(this, "Clicked: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(p0: View?) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
