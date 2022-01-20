package com.example.moviejash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.google.firebase.ktx.Firebase

class MainActivity_CreditCard : AppCompatActivity() {

    private lateinit var SecondBuyTicket: Button
    private lateinit var CardNumber: EditText
    private lateinit var Month: EditText
    private lateinit var Year: EditText
    private lateinit var Cvv: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_credit_card)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        init()

        SecondBuyTicket.setOnClickListener() {

//            დიალოგის მერე უნდა დაიწყოს ეს ექთივითი

//            startActivity(Intent(this, bottom_nav_second::class.java))
//            finish()

            var cardnumber = CardNumber.text.toString()
            var month = Month.text.toString()
            var year = Year.text.toString()
            var cvv = Cvv.text.toString()

            if (cardnumber.isEmpty() || cardnumber.length != 16 || !cardnumber.matches(".*[0-9].*".toRegex())) {
                CardNumber.error = "Enter Valid Card Number"
            }
            else if (month.isEmpty() || !(month.toInt() <= 12 && month.toInt() == 0)) {
                Month.error = "Enter A Month"
            }
            else if (year.isEmpty() || !(year.toInt() >= 2020 && year.toInt() <= 2030)) {
                Year.error = "Enter A Year"
            }
            else if (cvv.isEmpty() || cvv.length != 3) {
                Cvv.error = "CVV Must Contain 3 numbers"
            }
            else AlertDialog.Builder(this).setTitle("Confirm Purchase")
                .setMessage("Are You Sure You Want To Buy this Ticket?")
                .setPositiveButton("Yes") { dialog, i ->

                    dialog.dismiss()
                    goToMovies()
                }
                .setNegativeButton("No") { dialog, i ->

                    dialog.dismiss()
                    goToMovies()
                }
                .setNeutralButton("Cancel") {dialog, i ->

                    dialog.dismiss()
                    goToMovies()
                }

        }
    }

    private fun init() {

        CardNumber = findViewById(R.id.cardNumber)
        Month = findViewById(R.id.month)
        Year = findViewById(R.id.year)
        Cvv = findViewById(R.id.cvv)
        SecondBuyTicket = findViewById(R.id.SecondBuyTicket)

    }

    private fun goToMovies() {
        startActivity(Intent(this, bottom_nav_second::class.java))
        finish()
    }
}