package com.example.bilibeadsdesigns.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.bilibeadsdesigns.LoginActivity
import com.example.bilibeadsdesigns.R

class SplashScreen : AppCompatActivity() {
    private val SPLASHTIME: Long = 3000


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_splash_screen)


        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()

        }, SPLASHTIME)
    }
}