package com.mgbachi_ugo.hngshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductRecyclerAdapter(private val context: Context, private val products: List<Products>, private val itemClick: (Products) -> Unit): RecyclerView.Adapter<ProductRecyclerAdapter.Holder>(){

    inner class Holder(itemView: View, val itemClick: (Products) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.product_image)
        private val productCategory: TextView = itemView.findViewById(R.id.pproduct_category)
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productPrice: TextView = itemView.findViewById(R.id.product_price)

        fun bindProduct(product: Products, context: Context){
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage.setImageResource(resourceId)
            productCategory.text = " Category: ${product.category}"
            productName.text = "Name: \n ${product.title}"
            productPrice.text = "Price:  ${product.price}"
            itemView.setOnClickListener { itemClick(product) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val  view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
      return products.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    holder.bindProduct(products[position], context)
    }
}