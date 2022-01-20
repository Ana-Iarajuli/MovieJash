package com.example.moviejash.fragments_authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviejash.R
import com.example.moviejash.UserInfo
import com.example.moviejash.bottom_nav_second
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistrationFragment: Fragment (R.layout.fragment_registration) {

    private lateinit var RegistrationButton: Button
    private lateinit var LoginButton: TextView
    private lateinit var Username: EditText
    private lateinit var Email: EditText
    private lateinit var Password: EditText
    private lateinit var RepeatPassword: EditText

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        val controller = Navigation.findNavController(view)

        LoginButton.setOnClickListener() {

            val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            controller.navigate(action)

        }

        RegistrationButton.setOnClickListener() {

            var username = Username.text.toString()
            var email = Email.text.toString()
            var password = Password.text.toString()
            var repeat_password = RepeatPassword.text.toString()

            if (username.isEmpty() || username.length < 3) {
                Username.error = "Enter Your Name"
            }
            else if (email.isEmpty() || !email.contains("@")){
                Email.error = "Enter A Valid Email"
            }
            else if (password.isEmpty() || password.length < 8) {
                Password.error = "Password Must Contain At Least 8 Characters!"
            }
            else if (repeat_password != password) {
                RepeatPassword.error = "Password Mismatch!"
            }
            else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            registerListener()
                        }
                        else {
                            Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                        }

                    }
            }
        }

    }

    private fun init() {

        RegistrationButton = requireView().findViewById(R.id.RegistrationButton)
        LoginButton = requireView().findViewById(R.id.LoginButton)
        Username = requireView().findViewById(R.id.Username)
        Email = requireView().findViewById(R.id.Email)
        Password = requireView().findViewById(R.id.Password)
        RepeatPassword = requireView().findViewById(R.id.RepeatPassword)

    }

    private fun registerListener() {
        RegistrationButton.setOnClickListener() {

            val saveusername = Username.text.toString()
            val savemail = Email.text.toString()
            val userInfo = UserInfo(saveusername, savemail)
            db.child(auth.currentUser?.uid!!).setValue(userInfo)

            startActivity(Intent(requireActivity(), bottom_nav_second::class.java))
            requireActivity().finish()
        }

    }

}