package com.example.academiadanza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import java.util.HashMap

class InicioSesionActivity : AppCompatActivity() {

    // 1. Crear objetos de tipo control para el DOM
    private lateinit var btnIngresar: Button
    private lateinit var txtUsuario: EditText
    private lateinit var txtContrasena: EditText
    private lateinit var txtDia: EditText
    private lateinit var txtMes: EditText

    private lateinit var mfirestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_sesion) // Asegúrate de que el layout sea correcto

        mfirestore = FirebaseFirestore.getInstance() // Apuntar al Firebase

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

        // 2. Relacionar cada objeto con el correspondiente control dentro del documento (formulario)
        // objetos de cuadros de texto con el respectivo control Plain Text del documento
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContrasena = findViewById(R.id.txtContrasena)
        txtDia = findViewById(R.id.txtDia)
        txtMes = findViewById(R.id.txtMes)

        // objetos de tipo botón con el respectivo control Button del documento
        btnIngresar = findViewById(R.id.btnIngresar)

        // 3. Crear el código para la programación del evento onClick del botón btnIngresar
        btnIngresar.setOnClickListener {
            // 3.a Dentro del evento onClick se obtiene el texto escrito por el usuario
            // tanto en el control usuario como en la contraseña
            val datoUsuario = txtUsuario.text.toString().trim()
            val datoContrasena = txtContrasena.text.toString().trim()
            val datoDia = txtDia.text.toString().trim()
            val datoMes = txtMes.text.toString().trim()

            // 3b. Validar que los cuadros de texto no contengan nulos
            when {
                datoUsuario.isEmpty() && datoContrasena.isEmpty() && datoDia.isEmpty() && datoMes.isEmpty() -> {
                    Toast.makeText(this, "Debe ingresar el usuario y contraseña", Toast.LENGTH_SHORT).show()
                }
                datoUsuario.isEmpty() -> {
                    Toast.makeText(this, "Debe ingresar el usuario", Toast.LENGTH_SHORT).show()
                }
                datoContrasena.isEmpty() -> {
                    Toast.makeText(this, "Debe ingresar la contraseña", Toast.LENGTH_SHORT).show()
                }
                datoDia.isEmpty() -> {
                    Toast.makeText(this, "Debe ingresar el día de nacimiento", Toast.LENGTH_SHORT).show()
                }
                datoMes.isEmpty() -> {
                    Toast.makeText(this, "Debe ingresar el mes de nacimiento", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    validarUsuarioContrasena(datoUsuario, datoContrasena, datoDia, datoMes)
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.InicioSesion)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun validarUsuarioContrasena(datoUsuario: String, datoContrasena: String, datoDia: String, datoMes: String) {
        val map = HashMap<String, Any>()
        map["usuario"] = datoUsuario
        map["contrasena"] = datoContrasena
        map["dia"] = datoDia
        map["mes"] = datoMes

        mfirestore.collection("accesso").add(map)
            .addOnSuccessListener {
                Toast.makeText(applicationContext, "Inicio de sesion correcto", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            }
    }
}