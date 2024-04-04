package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btEntrar: Button = findViewById<Button>(R.id.btEntrar)

        btEntrar.setOnClickListener {
            val etUsuario = findViewById<EditText>(R.id.etUsuario)
            val etSenha = findViewById<EditText>(R.id.etSenha)

            if (etUsuario.text.toString() != "" && etSenha.text.toString() != "") {

                var user = BD.users.firstOrNull() { it -> it.username == etUsuario.text.toString() }

                if(user != null){
                    val sysUser = user.username
                    val sysSenha = user.senha

                    if (etSenha.text.toString() == sysSenha && etUsuario.text.toString() == sysUser) {
                        Toast.makeText(this, "Seja bem vindo " + etUsuario.text.toString(), Toast.LENGTH_LONG).show()
                        val newIntent = Intent(this, CalculadoraActivity::class.java)
                        startActivity(newIntent)
                    } else {
                        Toast.makeText(this, "Usuario ou senha inválidos!", Toast.LENGTH_SHORT).show()
                    }

                }else {
                    Toast.makeText(this, "Usuario não encontrado", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Digite o usuário e senha", Toast.LENGTH_SHORT).show()
            }

        }

        val btCadastrar: Button = findViewById<Button>(R.id.btCadastrar)

        btCadastrar.setOnClickListener {
            val newIntent = Intent(this, CadastroActivity::class.java)
            startActivity(newIntent)
        }
    }
}