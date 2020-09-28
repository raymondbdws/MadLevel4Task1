package com.rayray.madlevel4task1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rayray.madlevel4task1.R
import com.rayray.madlevel4task1.model.Product
import kotlinx.android.synthetic.main.product.view.*


class ProductAdapter(private val product: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun databind(product: Product){
            itemView.tvShoppingItem.text = product.name
            itemView.tvQuantity.text = product.quantity.toString() + "x"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product,
                parent, false)
        )
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(product[position])
    }
}