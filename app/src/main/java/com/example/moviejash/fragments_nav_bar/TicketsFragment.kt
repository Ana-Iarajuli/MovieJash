package com.example.moviejash.fragments_nav_bar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.moviejash.MainActivity_CreditCard
import com.example.moviejash.R

class TicketsFragment: Fragment (R.layout.fragment_tickets){

    private lateinit var BuyTicket: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        BuyTicket.setOnClickListener() {

            goToCreditCardActivity()

        }

    }

    private fun init() {

        BuyTicket = requireActivity().findViewById(R.id.buyTicket)

    }

    private fun goToCreditCardActivity() {
        startActivity(Intent(requireActivity(), MainActivity_CreditCard::class.java))
        requireActivity().finish()
    }

}