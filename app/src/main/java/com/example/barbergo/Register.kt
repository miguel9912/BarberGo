package com.example.barbergo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            if (binding.txtEmailRegister.text.isNotEmpty() && binding.txtContrasenaRegister.text.isNotEmpty()){
                if(binding.txtContrasenaRegister.text.toString().equals(binding.txtContrasena2Register.text.toString())){
                    firebaseauth.createUserWithEmailAndPassword(binding.txtEmailRegister.text.toString(),binding.txtContrasenaRegister.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            irHome(it.result?.user?.email?:"",Proveedor.BASIC)  //Esto de los interrogantes es por si está vacío el email, que enviaría una cadena vacía.
                        } else {
                            showAlert("Error registrando al usuario.")
                        }
                    }.addOnFailureListener{
                        Toast.makeText(this, "Conexión no establecida", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT)
                }

            }
            else {
                showAlert("Rellene los campos")
            }
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

    private fun irHome(email:String, provider:Proveedor, nombre:String = "Usuario"){
        Log.e("MHP","Valores: ${email}, ${provider}, ${nombre}")
        val homeIntent = Intent(this, Home::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
            putExtra("nombre",nombre)
        }
        startActivity(homeIntent)
    }

    private fun showAlert(msg:String = "Se ha producido un error autenticando al usuario"){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(msg)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog= builder.create()
        dialog.show()
    }
}