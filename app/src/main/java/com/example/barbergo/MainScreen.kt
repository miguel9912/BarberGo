package com.example.barbergo

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.barbergo.databinding.ActivityMainScreenBinding
import com.example.barbergo.databinding.ActivityRegisterBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MainScreen : AppCompatActivity()  {
    lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tabLayout = binding.tabLayout
        var viewPager = binding.viewPager
        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager){tab, index ->
            tab.text = when(index){
                0 -> {"Primer"}
                1 -> {"Second"}
                else -> {throw Resources.NotFoundException("Posición no hallada")}
            }
        }.attach()

    }


}