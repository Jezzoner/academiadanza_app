package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.academiadanza.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonInicio = findViewById<Button>(R.id.Inicio)

        buttonInicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de "Crear Producto/Servicio"
        binding.btnCreateProduct.setOnClickListener {
            val intent = Intent(this, CreateProductActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de "Actualizar Producto/Servicio"
        binding.btnUpdateProduct.setOnClickListener {
            val intent = Intent(this, UpdateProductActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de "Consultar Clientes"
        binding.btnReadAllProduct.setOnClickListener {
            val intent = Intent(this, ViewClientsActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de "Consultar Productos"
        binding.btnCreateUser.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }
}
