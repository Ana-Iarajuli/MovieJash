package com.example.moviejash.fragments_authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviejash.R
import com.example.moviejash.bottom_nav_second
import com.example.moviejash.fragments_nav_bar.MoviesFragment
import com.google.firebase.auth.FirebaseAuth

class RegistrationFragment: Fragment (R.layout.fragment_registration) {

    private lateinit var RegistrationButton: Button
    private lateinit var LoginButton: Button
    private lateinit var Name: EditText
    private lateinit var Surname: EditText
    private lateinit var Email: EditText
    private lateinit var Password: EditText
    private lateinit var RepeatPassword: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        val controller = Navigation.findNavController(view)

        LoginButton.setOnClickListener() {

            val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            controller.navigate(action)

        }

        RegistrationButton.setOnClickListener() {

            var name = Name.text.toString()
            var surname = Surname.text.toString()
            var email = Email.text.toString()
            var password = Password.text.toString()
            var repeat_password = RepeatPassword.text.toString()

            if (name.isEmpty() || name.length < 3) {
                Name.error = "Enter Your Name"
            }
            else if (surname.isEmpty() || surname.length < 3) {
                Surname.error = "Enter Your Surname"
            }
            else if (email.isEmpty() || !email.contains("@")){
                Email.error = "Enter A Valid Email"
            }
            else if (password.isEmpty() || password.length < 8) {
                Password.error = "Password Must Contain At Least 8 characters!"
            }
            else if ("!@#$%^&*()_+=" !in password) {
                Password.error = "Password Must Contain At Least One Special Symbol!"
            }
            else FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        registerListener()
                    }

                }

        }

    }

    private fun init() {

        RegistrationButton = requireView().findViewById(R.id.RegistrationButton)
        LoginButton = requireView().findViewById(R.id.LoginButton)
        Name = requireView().findViewById(R.id.Name)
        Surname = requireView().findViewById(R.id.Surname)
        Email = requireView().findViewById(R.id.Email)
        Password = requireView().findViewById(R.id.Password)
        RepeatPassword = requireView().findViewById(R.id.RepeatPassword)

    }

    private fun registerListener() {
        RegistrationButton.setOnClickListener() {
            startActivity(Intent(requireActivity(), bottom_nav_second::class.java))
            requireActivity().finish()
        }

    }

}