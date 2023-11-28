package com.example.barbergo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.barbergo.databinding.ActivityMainScreenBinding
import com.example.barbergo.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class MainScreen : AppCompatActivity()  {
    lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnadirClientes.setOnClickListener {

        }

        binding.btnVolverScreen.setOnClickListener{
            irMain()
        }


    }

    private fun irMain(){
        val homeIntent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(homeIntent)
    }

}