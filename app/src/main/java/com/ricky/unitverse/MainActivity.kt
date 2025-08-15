package com.ricky.unitverse

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val aboutFragment = AboutFragment()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        switchFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeIcon -> {
                    switchFragment(homeFragment)
                    true
                }
                R.id.aboutIcon -> {
                    switchFragment(aboutFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun switchFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.currentFragment, fragment)
            commit()

    }
}