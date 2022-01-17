package com.example.moviejash.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.moviejash.R

class StartFragment: Fragment (R.layout.fragment_start) {

    private lateinit var startButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startButton = view.findViewById(R.id.startButton)

        startButton.setOnClickListener {

        }
    }
}