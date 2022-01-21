package com.example.moviejash.fragments_nav_bar

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.moviejash.MainActivity_CreditCard
import com.example.moviejash.R

class TicketsFragment: Fragment (R.layout.fragment_tickets){

    private lateinit var BuyTicket: Button
    private lateinit var E1: Button
    private lateinit var E2: Button
    private lateinit var E3: Button
    private lateinit var E4: Button
    private lateinit var D1: Button
    private lateinit var D2: Button
    private lateinit var D3: Button
    private lateinit var D4: Button
    private lateinit var C1: Button
    private lateinit var C2: Button
    private lateinit var C3: Button
    private lateinit var C4: Button
    private lateinit var B1: Button
    private lateinit var B2: Button
    private lateinit var B3: Button
    private lateinit var B4: Button
    private lateinit var A1: Button
    private lateinit var A2: Button
    private lateinit var A3: Button
    private lateinit var A4: Button
    private lateinit var Seats: TextView
    private lateinit var Price: TextView

    private var seatsNumber = 20
    private var priceNumber = 0

    private var i = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        E1.setOnClickListener(){
            if (i == 0) {
                onClicked()
            }
            else if (i == 1) {
                unClick()
            }
        }
        E2.setOnClickListener(){
            if (i == 0) {
                onClicked()
//                i++
//                E2.setBackgroundColor(Color.YELLOW)
            }
            else if (i == 1) {
                unClick()
//                i--
//                E2.setBackgroundColor(Color.TRANSPARENT)
            }
        }
        E3.setOnClickListener(){
            if (E3.isEnabled) {
                onClicked()
            }
            else {
                unClick()
            }
        }
        E4.setOnClickListener(){
            if (E4.isEnabled) {
                onClicked()
            }
            else {
                unClick()
            }
        }
        D1.setOnClickListener(){
            if (D1.isEnabled) {
                onClicked()
            }
            else {
                unClick()
            }
        }
        D2.setOnClickListener(){
            if (D2.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        D3.setOnClickListener(){
            if (D3.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        D4.setOnClickListener(){
            if (D4.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        C1.setOnClickListener(){
            if (C1.isEnabled) {
                onClicked()
            }
            else {
                unClick()
            }
        }
        C2.setOnClickListener(){
            if (C2.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        C3.setOnClickListener(){
            if (C3.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        C4.setOnClickListener(){
            if (C4.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        B1.setOnClickListener(){
            if (B1.isEnabled) {
                onClicked()
            }
            else {
                unClick()
            }
        }
        B2.setOnClickListener(){
            if (B2.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        B3.setOnClickListener(){
            if (B3.isEnabled) {
                onClicked()
            }
            else {
                unClick()
            }
        }
        B4.setOnClickListener(){
            if (B4.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        A1.setOnClickListener(){
            if (A1.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        A2.setOnClickListener(){
            if (A2.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        A3.setOnClickListener(){
            if (A3.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }
        A4.setOnClickListener(){
            if (A4.isEnabled) {
                onClicked()
            }else {
                unClick()
            }
        }


        BuyTicket.setOnClickListener() { goToCreditCardActivity() }

    }

    private fun goToCreditCardActivity() {
        startActivity(Intent(requireActivity(), MainActivity_CreditCard::class.java))
        requireActivity().finish()
    }

    private fun init() {
        BuyTicket = requireView().findViewById(R.id.buyTicket)
        E1 = requireView().findViewById(R.id.e1)
        E2 = requireView().findViewById(R.id.e2)
        E3 = requireView().findViewById(R.id.e3)
        E4 = requireView().findViewById(R.id.e4)
        D1 = requireView().findViewById(R.id.d1)
        D2 = requireView().findViewById(R.id.d2)
        D3 = requireView().findViewById(R.id.d3)
        D4 = requireView().findViewById(R.id.d4)
        C1 = requireView().findViewById(R.id.c1)
        C2 = requireView().findViewById(R.id.c2)
        C3 = requireView().findViewById(R.id.c3)
        C4 = requireView().findViewById(R.id.c4)
        B1 = requireView().findViewById(R.id.b1)
        B2 = requireView().findViewById(R.id.b2)
        B3 = requireView().findViewById(R.id.b3)
        B4 = requireView().findViewById(R.id.b4)
        A1 = requireView().findViewById(R.id.a1)
        A2 = requireView().findViewById(R.id.a2)
        A3 = requireView().findViewById(R.id.a3)
        A4 = requireView().findViewById(R.id.a4)

        Seats = requireView().findViewById(R.id.seatsNumber)
        Price = requireView().findViewById(R.id.priceNumber)

    }


    private fun onClicked() {
            seatsNumber = seatsNumber - 1
            Seats.text = "$seatsNumber"
            priceNumber = priceNumber + 15
            Price.text = "$priceNumber"
            i++
            E2.setBackgroundColor(Color.YELLOW)
    }

    private fun unClick() {
        seatsNumber = seatsNumber + 1
        Seats.text = "$seatsNumber"
        priceNumber = priceNumber - 15
        Price.text = "$priceNumber"
        i == 0
        E2.setBackgroundColor(Color.TRANSPARENT)
    }


}