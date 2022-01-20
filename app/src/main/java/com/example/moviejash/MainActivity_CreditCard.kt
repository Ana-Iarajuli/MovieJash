package com.example.moviejash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar

class MainActivity_CreditCard : AppCompatActivity() {

    private lateinit var SecondBuyTicket: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_credit_card)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        SecondBuyTicket = findViewById(R.id.SecondBuyTicket)

        SecondBuyTicket.setOnClickListener() {

            startActivity(Intent(this, bottom_nav_second::class.java))
            finish()

        }
    }
}