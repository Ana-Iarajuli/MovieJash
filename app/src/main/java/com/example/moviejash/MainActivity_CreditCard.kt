package com.example.moviejash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class MainActivity_CreditCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_credit_card)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }
}