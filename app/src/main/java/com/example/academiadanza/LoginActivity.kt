package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.setDisplayShowHomeEnabled(true)

        //Boton de registro
        val buttonRegistro = findViewById<Button>(R.id.btnRegistro)
        buttonRegistro.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        //Boton de inicio
        val buttonInicio = findViewById<Button>(R.id.Inicio)
        buttonInicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val email = findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if (email.text.toString() == "Jesus" && password.text.toString() == "1234") {
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_LONG).show()
            }
        }





    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher;
        return false
    }
}
