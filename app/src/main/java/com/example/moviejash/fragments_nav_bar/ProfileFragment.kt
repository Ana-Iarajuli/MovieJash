package com.example.moviejash.fragments_nav_bar

import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.moviejash.MainActivity
import com.example.moviejash.PasswordReset
import com.example.moviejash.R

class ProfileFragment: Fragment (R.layout.fragment_profile){

    private lateinit var ResPasswordButton: Button
    private lateinit var LogoutButton: Button
    private lateinit var UserPhoto: ImageView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ResPasswordButton = requireActivity().findViewById(R.id.ResPasswordButton)
        LogoutButton = requireActivity().findViewById(R.id.LogoutButton)
        UserPhoto = requireActivity().findViewById(R.id.UserPhoto)


        ResPasswordButton.setOnClickListener() {
            startActivity(Intent(requireActivity(), PasswordReset::class.java))
            requireActivity().finish()

        }
        LogoutButton.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()
        }




    }


}