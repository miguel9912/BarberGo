package com.example.barbergo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barbergo.databinding.ActivityMainBinding
import com.example.barbergo.databinding.ActivityRegisterBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseauth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseauth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {

        }

        binding.btnVolver.setOnClickListener{
            irMain()
        }

        binding.btnContacts.setOnClickListener{
            irContacts()
        }


    }

    private fun irMain(){
        val mainIntent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(mainIntent)
    }

    private fun irContacts(){
        val contactsIntent = Intent(this, Ventana2::class.java).apply {
        }
        startActivity(contactsIntent)
    }
}