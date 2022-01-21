package com.example.moviejash.fragments_nav_bar

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
import com.example.moviejash.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment: Fragment (R.layout.fragment_profile){

    private lateinit var ResPasswordButton: Button
    private lateinit var LogoutButton: Button
    private lateinit var UserPhoto: ImageView

    private lateinit var retriveUsername: TextView
    private lateinit var retriveEmail: TextView
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ResPasswordButton = view.findViewById(R.id.ResPasswordButton)
        LogoutButton = view.findViewById(R.id.LogoutButton)
        UserPhoto = view.findViewById(R.id.UserPhoto)
        retriveUsername = view.findViewById(R.id.retriveUsername)
        retriveEmail = view.findViewById(R.id.retriveEmail)

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userinfo = snapshot.getValue(UserInfo::class.java) ?: return
                retriveUsername.text = userinfo.username
                retriveEmail.text = userinfo.mail
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


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