package com.example.moviejash.fragments_authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.moviejash.R
import com.example.moviejash.bottom_nav_second
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment (R.layout.fragment_login) {

    private lateinit var Email2: EditText
    private lateinit var Password2: EditText
    private lateinit var LogInButton2: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        LogInButton2.setOnClickListener() {
            val email2 = Email2.text.toString()
            val password2 = Password2.text.toString()

            if (email2.isEmpty() || password2.isEmpty()) {
                Toast.makeText(requireActivity(), "Please Enter Email And Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email2, password2)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        goToBottomNavActivity()

                    }
            }

        }

    }

    private fun init() {
        Email2 = requireActivity().findViewById(R.id.Email2)
        Password2 = requireActivity().findViewById(R.id.Password2)
        LogInButton2 = requireView().findViewById(R.id.logInButton2)
    }

    private fun goToBottomNavActivity() {
        startActivity(Intent(requireActivity(), bottom_nav_second::class.java))
        requireActivity().finish()
    }


}