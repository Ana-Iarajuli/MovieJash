package com.example.moviejash

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetPassword: AppCompatActivity() {

    private lateinit var EmailForReset: EditText
    private lateinit var ResetPassword: Button

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.reset_password)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        EmailForReset = findViewById(R.id.EmailForReset)
        ResetPassword = findViewById(R.id.resetPassword)

        ResetPassword.setOnClickListener() {

            val emailForReset = EmailForReset.text.toString()

            Firebase.auth.sendPasswordResetEmail(emailForReset).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    Toast.makeText(this, "Check Your Email", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Enter valid Email", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}