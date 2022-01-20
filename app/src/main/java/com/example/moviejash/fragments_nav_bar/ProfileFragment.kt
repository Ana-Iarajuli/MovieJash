package com.example.moviejash.fragments_nav_bar

import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.moviejash.MainActivity
import com.example.moviejash.PasswordReset
import com.example.moviejash.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ProfileFragment: Fragment (R.layout.fragment_profile){
    private lateinit var ResPasswordButton: Button
    private lateinit var LogoutButton: Button
    private lateinit var UserPhoto: ImageView
    private lateinit var Camera: Button
    private lateinit var savedusername: TextView
    private lateinit var savedemail: TextView
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")

    companion object{
        val IMAGE_REQUEST_CODE = 100

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ResPasswordButton = requireActivity().findViewById(R.id.ResPasswordButton)
        LogoutButton = requireActivity().findViewById(R.id.LogoutButton)
        Camera = requireActivity().findViewById(R.id.Camera)
        UserPhoto = requireActivity().findViewById(R.id.UserPhoto)
        savedusername = requireActivity().findViewById(R.id.savedmail)




        ResPasswordButton.setOnClickListener() {
            startActivity(Intent(requireActivity(), PasswordReset::class.java))
            requireActivity().finish()

        }
        LogoutButton.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()
        }
        Camera.setOnClickListener {
            pickImageGallery()
        }


    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        requireActivity().startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            UserPhoto.setImageURI(data?.data)
        }
    }



}