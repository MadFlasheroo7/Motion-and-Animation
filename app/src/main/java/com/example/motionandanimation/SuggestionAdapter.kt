package com.example.motionandanimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item.view.*

class SuggestionAdapter(private var products: ArrayList<Products>) : RecyclerView.Adapter<SuggestionAdapter.ProductViewHolder>(){
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.itemView.product_name.text = product.productName
        holder.itemView.productCost.text = product.productCost
        val img =  products[position].ProductImage
        holder.itemView.productImg.setImageResource(img)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}