package com.example.academiadanza

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.academiadanza.databinding.ActivityCreateProductBinding

class CreateProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveProduct.setOnClickListener {
            val productName = binding.etProductName.text.toString()
            val productPrice = binding.etProductPrice.text.toString()

            if (productName.isNotBlank() && productPrice.isNotBlank()) {
                Toast.makeText(this, "Producto guardado: $productName ($productPrice)", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
