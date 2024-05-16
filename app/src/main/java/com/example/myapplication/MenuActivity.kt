package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btCalculadora: Button = findViewById<Button>(R.id.btCalculadora)
        val btUsuario: Button = findViewById<Button>(R.id.btUsuario)
        val btVoltar: Button = findViewById<Button>(R.id.btVoltarMenu)

        btCalculadora.setOnClickListener {
            val newIntent = Intent(this, CalculadoraActivity::class.java)
            startActivity(newIntent)
        }

        btUsuario.setOnClickListener {
            val newIntent = Intent(this, UsuarioActivity::class.java)
            startActivity(newIntent)
        }


        btVoltar.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
    }
}