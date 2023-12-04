package com.example.bilibeadsdesigns.AddToCart




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeadsdesigns.Dashboard.DataClassDashboard

import com.example.bilibeadsdesigns.R





class CartAdapter(private val cartItems: MutableList<DataClassNew>, private val cart: Cart) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv_beads)
        val itemDescription: TextView = itemView.findViewById(R.id.tv_title)
        //added
        val itemDelete: Button = itemView.findViewById(R.id.delete_tv)
        val itemPrice: TextView = itemView.findViewById(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_cart_product_display_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataClassDashboard = cartItems[position]
        holder.itemImage.setImageResource(dataClassDashboard.image)
        holder.itemDescription.text = dataClassDashboard.title
        holder.itemPrice.text = dataClassDashboard.price.toString()


        holder.itemDelete.setOnClickListener {
            val itemToDelete = cartItems[position]
            cart.deleteCartItem(itemToDelete)
            cartItems.removeAt(position)
            notifyDataSetChanged()
            val itemTitle = itemToDelete.title
            val message = "$itemTitle Removed from the cart"
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }

    }
    override fun getItemCount(): Int {
        return cartItems.size
    }


}

