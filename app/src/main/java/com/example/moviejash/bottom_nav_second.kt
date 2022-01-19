package com.example.moviejash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class bottom_nav_second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_second)

        val navView = findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        val controller = findNavController(R.id.nav_movies_fragment)

        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.moviesFragment,
                R.id.ticketsFragment,
                R.id.profileFragment
            )
        )

        setupActionBarWithNavController(controller, appBarConfig)
        navView.setupWithNavController(controller)

    }
}