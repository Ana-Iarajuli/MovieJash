package com.example.moviejash.fragments_authentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.moviejash.R

class RegistrationFragment: Fragment (R.layout.fragment_registration) {

    private lateinit var RegistrationButton: Button
    private lateinit var LoginButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RegistrationButton = view.findViewById(R.id.RegistrationButton)
        LoginButton = view.findViewById(R.id.LoginButton)

        RegistrationButton.setOnClickListener {

        }


        LoginButton.setOnClickListener {

        }
    }
}