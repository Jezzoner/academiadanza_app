package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contacto)

        val buttonInicio = findViewById<Button>(R.id.Inicio)

        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val apellido = findViewById<EditText>(R.id.editTextApellido)
        val direccion = findViewById<EditText>(R.id.editTextDireccion)
        val btnEnviar = findViewById<Button>(R.id.btnEnviarMensaje)
        val spinnerCiudades = findViewById<Spinner>(R.id.spinnerCiudades)

        val radioEcuatoriano = findViewById<RadioButton>(R.id.radioButton)
        val radioExtranjero = findViewById<RadioButton>(R.id.radioButton2)

        radioEcuatoriano.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioExtranjero.isChecked = false
            }
        }
        radioExtranjero.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioEcuatoriano.isChecked = false
            }
        }
        val ciudades = listOf("Ciudad", "Quito", "Guayaquil", "Cuenca", "Santo Domingo", "Riobamba", "Machala", "Ambato", "Loja")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ciudades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCiudades.adapter = adapter

        btnEnviar.setOnClickListener {
            val ciudadSeleccionada = spinnerCiudades.selectedItem.toString()

            if (ciudadSeleccionada == "Seleccionar") {
                Toast.makeText(this, "Por favor, seleccione una ciudad", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val datos = """
                Nombre: ${nombre.text}
                Apellido: ${apellido.text}
                Ciudad: $ciudadSeleccionada
                Dirección: ${direccion.text}
            """.trimIndent()

            Toast.makeText(this, "Mensaje Enviado Satisfactoriamente:\n$datos", Toast.LENGTH_LONG).show()
        }

        buttonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.contacto)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
