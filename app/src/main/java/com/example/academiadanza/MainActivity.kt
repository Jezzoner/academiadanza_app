package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.academiadanza.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseStore: FirebaseFirestore
    private lateinit var firebaseStorage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.InicioSesion.setOnClickListener {
            val intent = Intent(this, InicioSesionActivity::class.java)
            startActivity(intent)
        }

        binding.Empresa.setOnClickListener {
            val intent = Intent(this, EmpresaActivity::class.java)
            startActivity(intent)
        }

        binding.Reserva.setOnClickListener {
            val intent = Intent(this, ReservaActivity::class.java)
            startActivity(intent)
        }

        binding.buttonCursos.setOnClickListener {
            val intent = Intent(this, CursosActivity::class.java)
            startActivity(intent)
        }

        binding.buttonContacto.setOnClickListener {
            val intent = Intent(this, ContactoActivity::class.java)
            startActivity(intent)
        }

        binding.buttonQuienesSomos.setOnClickListener {
            val intent = Intent(this, QuienesSomosActivity::class.java)
            startActivity(intent)
        }
        binding.btnAdmin.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
