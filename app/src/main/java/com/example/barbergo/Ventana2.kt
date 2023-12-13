package com.example.barbergo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import com.example.barbergo.databinding.ActivityVentana2Binding


class Ventana2 : AppCompatActivity() {
    private lateinit var binding: ActivityVentana2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ACSCO", "ONCREATE(), Ventana 2")
        binding = ActivityVentana2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_ventana2)

        /*var nombre = intent.getStringExtra("nombre")
        var edad = intent.getStringExtra("edad")
        var persona:Persona = Persona(nombre,edad)*/
        //var dc : modelo.Cliente = intent.getSerializableExtra("obj") as modelo.Cliente
        /*binding.cajaNombre.setText(dc.nombre)
        binding.cajaEdad.setText(p.edad)*/


       /* Clientes.aniadirPersona(dc)
        var cadena: String = ""
        var i:Int=1
        for(p in Clientes.clientes){
            cadena+=" "+i+". " +p.nombre+" "+p.edad +"\n"
            i++
            binding.multiLine.setText(cadena)
        }
        binding.boton.setOnClickListener {
            finish()
        }*/

        //Devolver datos a la ventana 1 de forma deprecated.
        binding.btDevolver.setOnClickListener {
            // Get the text from the EditText

            anadirContactos()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e("ACSCO", "ONSTART(), Ventana 2")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ACSCO", "ONRESUME(), Ventana 2")
    }
    override fun onPause(){
        super.onPause()
        Log.e("ACSCO", "ONPAUSE(), Ventana 2")
    }
    override fun onStop() {
        super.onStop()
        Log.e("ACSCO", "ONSTOP(), Ventana 2")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("ACSCO", "ONDESTROY(), Ventana 2")
    }

    private fun anadirContactos(){
        var miIntent = Intent(this, VentanaContactos::class.java).apply{
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra("nombre", binding.cajaNombre.text.toString())
            putExtra("descripcion", binding.descripcion.text.toString())
        }
        if(miIntent.resolveActivity(packageManager) != null){
            startActivity(miIntent)
        }

    }
}