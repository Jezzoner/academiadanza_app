package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Referencias a los elementos del layout
        val txtCedula = findViewById<EditText>(R.id.txtCedula)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad)
        val txtDireccion = findViewById<EditText>(R.id.txtDireccion)
        val buttonInicio = findViewById<Button>(R.id.Inicio)

        // Botón para regresar a MainActivity
        buttonInicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
