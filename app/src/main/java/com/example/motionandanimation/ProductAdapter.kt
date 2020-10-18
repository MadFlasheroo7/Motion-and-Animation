package com.example.motionandanimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.swipe_item_1.view.*

class ProductAdapter (private val product:List<Products>):RecyclerView.Adapter<ProductAdapter.ViewPagerHolder>(){
    inner class ViewPagerHolder(itemView:View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.swipe_item_1,parent,false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val img =  product[position].ProductImage
        val products = product[position]
        holder.itemView.tagLine.text = products.tagline
        holder.itemView.productName.text = products.productName
        holder.itemView.productImage.setImageResource(img)
    }

    override fun getItemCount(): Int {
        return product.size
    }
}