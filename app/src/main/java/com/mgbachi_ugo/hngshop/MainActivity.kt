package com.mgbachi_ugo.hngshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgbachi_ugo.hngshop.ProductData.products
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ProductRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ProductRecyclerAdapter(this, ProductData.products) { products ->
            val productIntent = Intent(this, ProductActivity::class.java)
//passing the info of the item clicked to the product activity page through intent
           productIntent.putExtra(EXTRA_PRODUCT, products)
            startActivity(productIntent)

        }
        product_view.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        product_view.layoutManager = layoutManager
        product_view.setHasFixedSize(true)
    }
}
