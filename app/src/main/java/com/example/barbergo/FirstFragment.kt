package com.example.barbergo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.barbergo.databinding.FragmentFirstBinding
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import org.checkerframework.checker.nullness.qual.NonNull
import java.util.Objects


class FirstFragment : DialogFragment() {
    private lateinit var btnAdd: Button
    private lateinit var txtName: EditText
    private lateinit var txtDesc: EditText
    private lateinit var miFireStore : FirebaseFirestore
    private lateinit var binding : FragmentFirstBinding
    private lateinit var map : HashMap<String, String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        var v = inflater.inflate(R.layout.fragment_first, container, false)
        miFireStore = FirebaseFirestore.getInstance()
        txtName = binding.txtNombreCliente
        txtDesc = binding.txtDescripcionCliente
        btnAdd = binding.btnAnadirCliente


        if(txtName.text.toString().isBlank() || txtDesc.text.toString().isBlank()){
            Toast.makeText(context, "Hay campos sin rellenar", Toast.LENGTH_SHORT)
        }else{
            postCliente(txtName.text.toString(),txtDesc.text.toString())
        }
        return v
    }

    private fun postCliente(nombre: String, desc : String) {
        map.put("NAME", nombre)
        map.put("DESCRIPTION", desc)

        miFireStore.collection("client").add(map).addOnSuccessListener {
        Toast.makeText(context,"Cliente añadido exitosamente",Toast.LENGTH_SHORT)
            dialog?.dismiss()
        }.addOnFailureListener{
            Toast.makeText(context,"No se ha añadido ningún cliente",Toast.LENGTH_SHORT)
        }
    }




}