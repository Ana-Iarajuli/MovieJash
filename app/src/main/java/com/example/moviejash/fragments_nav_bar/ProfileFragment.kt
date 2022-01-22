package com.example.moviejash.fragments_nav_bar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.moviejash.MainActivity
import com.example.moviejash.PasswordReset
import com.example.moviejash.R
import com.example.moviejash.UserInfo
import com.example.moviejash.fragments_authentication.ProfilePicture
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.System.load

class ProfileFragment: Fragment (R.layout.fragment_profile){

    private lateinit var ResPasswordButton: Button
    private lateinit var LogoutButton: Button
    private lateinit var UserPhoto: ImageView
    private lateinit var profilePictureUrl: EditText

    private lateinit var retriveUsername: TextView
    private lateinit var retriveEmail: TextView
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")
    private val db2 = FirebaseDatabase.getInstance().getReference("ProfilePicture")



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ResPasswordButton = view.findViewById(R.id.ResPasswordButton)
        LogoutButton = view.findViewById(R.id.LogoutButton)
        UserPhoto = view.findViewById(R.id.UserPhoto)
        profilePictureUrl = view.findViewById(R.id.profilePictureUrl)
        retriveUsername = view.findViewById(R.id.retriveUsername)
        retriveEmail = view.findViewById(R.id.retriveEmail)

        getProfilePicture()

        db2.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val profilePicture = snapshot.getValue(ProfilePicture:: class.java) ?: return
                Glide.with(this@ProfileFragment).load(profilePicture.profilePicture).placeholder(R.drawable.ic_launcher_foreground).into(UserPhoto)


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })




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
    private fun getProfilePicture(){
        UserPhoto.setOnClickListener{
            var Url = profilePictureUrl.text.toString()
            val userPhoto = ProfilePicture(Url)
            db2.child(auth.currentUser?.uid!!).setValue(userPhoto)

        }
    }


}