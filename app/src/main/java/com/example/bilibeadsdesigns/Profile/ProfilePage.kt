package com.example.bilibeadsdesigns.Profile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.bilibeadsdesigns.AddToCart.CartActivity
import com.example.bilibeadsdesigns.Dashboard.Dashboard
import com.example.bilibeadsdesigns.HelpCenter.HelpCenter
import com.example.bilibeadsdesigns.LoginActivity
import com.example.bilibeadsdesigns.R

class ProfilePage : AppCompatActivity() {

    private lateinit var logoutButton : Button
    private lateinit var editProfile : Button
    private lateinit var changePass: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_profile)

        logoutButton = findViewById(R.id.bt_logout)
        editProfile = findViewById(R.id.edit_profile)
        changePass = findViewById(R.id.change_pass)

        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "LogOut", Toast.LENGTH_SHORT).show()
        }

        editProfile.setOnClickListener {
            Toast.makeText(this, "Successfully Change", Toast.LENGTH_SHORT).show()
        }

        changePass.setOnClickListener {
            Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show()
        }


        val dashboard = findViewById<ImageView>(R.id.iv_logo)
        dashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }

        val cart = findViewById<ImageView>(R.id.iv_cart)
        cart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        val helpCenter = findViewById<ImageView>(R.id.iv_profile)
        helpCenter.setOnClickListener {
            val intent = Intent(this,HelpCenter::class.java)
            startActivity(intent)
        }
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val intent = Intent(this,Dashboard::class.java)
        startActivity(intent)
        finish()
    }
}