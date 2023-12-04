package com.example.bilibeadsdesigns.AddToCart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.bilibeadsdesigns.Dashboard.Dashboard
import com.example.bilibeadsdesigns.Dashboard.DataClassDashboard
import com.example.bilibeadsdesigns.Profile.ProfilePage
import com.example.bilibeadsdesigns.R




class CartActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_shopping_cart)


        val cart = Cart(this)
        val cartItems = cart.getCartItems()

        val cartRecyclerView = findViewById<RecyclerView>(R.id.rv_cart)
        val cartAdapter = CartAdapter(cartItems as MutableList<DataClassNew>, cart)
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartRecyclerView.adapter = cartAdapter

        val dashboard = findViewById<ImageView>(R.id.iv_logo)
        dashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        val profilepage = findViewById<ImageView>(R.id.iv_profile)
        profilepage.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }



    }



}
