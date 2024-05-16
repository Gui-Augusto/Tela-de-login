package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class UsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        val btVoltar = findViewById<Button>(R.id.btVoltarUser)

        val lista = findViewById<ListView>(R.id.lista)

        val listaPessoas = BD.users
        val adapter = PessoaAdapter(this, listaPessoas)

        lista.adapter = adapter

        btVoltar.setOnClickListener{
            val newIntent = Intent(this, MenuActivity::class.java)
            startActivity(newIntent)
        }
    }
}