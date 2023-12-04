package com.example.bilibeadsdesigns.Product


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeadsdesigns.Dashboard.Dashboard
import com.example.bilibeadsdesigns.Dashboard.DataClassDashboard
import com.example.bilibeadsdesigns.R

class DashboardAdapter (private val getActivity: Dashboard, private val productList: List<DataClassDashboard>):
    RecyclerView.Adapter<DashboardAdapter.MyViewHolder>() {


    var onItemClick : ((DataClassDashboard) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_dashboard_product_display_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList[position]
        holder.productTitle.text = productList[position].title
        //holder.productPrice.text = productList[position].price
        holder.productPrice.text = productList[position].price.toString()
        holder.productImage.setImageResource(productList[position].image)
        holder.productImage.setImageResource(product.image)
        //holder  para a currency


        holder.itemView.setOnClickListener{
            onItemClick?.invoke(product)
            Log.d("ItemClicked", "Item clicked:$ {item.title}")
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productTitle : TextView = itemView.findViewById(R.id.tv_title)
        val productImage : ImageView = itemView.findViewById(R.id.iv_beads)
        val productPrice: TextView = itemView.findViewById(R.id.tv_price)


    }

}