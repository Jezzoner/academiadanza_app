package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReservaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva)

        val buttonInicio = findViewById<Button>(R.id.Inicio)

        buttonInicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val telefono = findViewById<EditText>(R.id.editTextTelefono)
        val servicio = findViewById<EditText>(R.id.editTextServicio)
        val btnEnviar = findViewById<Button>(R.id.btnEnviarReserva)

        btnEnviar.setOnClickListener {
            val datos = "Nombre: ${nombre.text}, Teléfono: ${telefono.text}, Servicio: ${servicio.text}"
            Toast.makeText(this, "Reserva Enviada: $datos", Toast.LENGTH_LONG).show()
        }
    }
}