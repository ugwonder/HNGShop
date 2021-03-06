package com.mgbachi_ugo.hngshop

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.product_item.*

class ProductActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

//getting the information through the intent
        val info =  intent.getParcelableExtra<Products>(EXTRA_PRODUCT)

        product_info.text =
            "This luxurious ${info.category} is up for grabs \n This ${info.title} only goes for ${info.price}"

        val resourceId = resources.getIdentifier(info.image, "drawable", packageName)
        productview.setImageResource(resourceId)

        btn_buy.setOnClickListener {
            Toast.makeText(this, "your item is being processed", Toast.LENGTH_SHORT).show()
        }

        btn_home.setOnClickListener {
            Toast.makeText(this, "you can have free drive and check it out \n its free!!", Toast.LENGTH_SHORT).show()
        }

    }


}
