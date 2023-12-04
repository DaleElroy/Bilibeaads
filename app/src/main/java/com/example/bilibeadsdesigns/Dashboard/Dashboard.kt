package com.example.bilibeadsdesigns.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibeadsdesigns.AddToCart.Cart
import com.example.bilibeadsdesigns.AddToCart.CartActivity
import com.example.bilibeadsdesigns.AddToCart.DataClassNew
import com.example.bilibeadsdesigns.AddToCart.ItemAdapter


import com.example.bilibeadsdesigns.Customize.Customize
import com.example.bilibeadsdesigns.Product.DashboardAdapter
import com.example.bilibeadsdesigns.Profile.ProfilePage
import com.example.bilibeadsdesigns.R

class Dashboard : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var productRecyclerviewAdapter: DashboardAdapter? = null


    private var productList = mutableListOf<DataClassDashboard>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_dashboard)

        val customizeButton = findViewById<AppCompatButton>(R.id.bt_customize)
        val profileButton = findViewById<ImageView>(R.id.iv_profile)
        val cartButton = findViewById<ImageView>(R.id.iv_cart)

        customizeButton.setOnClickListener {
            val intent = Intent(this, Customize::class.java)
            startActivity(intent)
        }
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
            finish()
        }
        cartButton.setOnClickListener {
            val intent = Intent (this, CartActivity::class.java)
            startActivity(intent)
        }


        productList = ArrayList()
        val items = mutableListOf(
            DataClassNew("Stussy Inpired",R.drawable.design12,"40PHP"),
            DataClassNew("Renek",R.drawable.design13,"40PHP"),
            DataClassNew("Pinkish",R.drawable.design14,"40PHP"),
            DataClassNew("Black&White",R.drawable.design15,"40PHP"),
            DataClassNew("Pearl W/Black Accent",R.drawable.design1,"40PHP"),
            DataClassNew("Black W/Pearl Accent",R.drawable.design2,"40PHP"),
            DataClassNew("Slim WBP",R.drawable.design3,"40PHP"),
            DataClassNew("Black Evil Eye",R.drawable.design4,"40PHP"),
            DataClassNew("Pearl Evil Eye",R.drawable.design5,"40PHP"),
            DataClassNew("Black Hearts",R.drawable.design6,"40PHP"),
            DataClassNew("B&W Drew",R.drawable.design7,"40PHP"),
            DataClassNew("Pink Hearts",R.drawable.design8,"40PHP"),
            DataClassNew("4 Evil Eyes",R.drawable.design9,"40PHP"),
            DataClassNew("B&W Evil Eye",R.drawable.design10,"40PHP"),
            DataClassNew("Royal Evil Eye",R.drawable.design11,"40PHP")
        )
        recyclerView = findViewById<View>(R.id.rv_dashboard) as RecyclerView
        this.productRecyclerviewAdapter = DashboardAdapter(this@Dashboard, productList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = productRecyclerviewAdapter
        val cart = Cart(this)
        val adapter = ItemAdapter (items,cart)

        recyclerView!!.adapter = adapter


        productRecyclerviewAdapter!!.onItemClick = {  item ->
            val intent = Intent(this, ViewProduct::class.java)
            intent.putExtra("product", item)
            startActivity(intent)
        }
        prepareProductListData()
    }


    private fun prepareProductListData() {
        var beads = DataClassDashboard("Stussy Inpired",R.drawable.design12,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Renek",R.drawable.design13,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Pinkish",R.drawable.design14,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Black&White",R.drawable.design15,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Pearl W/Black Accent",R.drawable.design1,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Black W/Pearl Accent",R.drawable.design2,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Slim WBP",R.drawable.design3,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Black Evil Eye",R.drawable.design4,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Pearl Evil Eye",R.drawable.design5,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Black Hearts",R.drawable.design6,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("B&W Drew",R.drawable.design7,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Pink Hearts",R.drawable.design8,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("4 Evil Eyes",R.drawable.design9,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("B&W Evil Eye",R.drawable.design10,"40PHP")
        productList.add(beads)
        beads = DataClassDashboard("Royal Evil Eye",R.drawable.design11,"40PHP")
        productList.add(beads)


        productRecyclerviewAdapter?.notifyDataSetChanged()
    }
}