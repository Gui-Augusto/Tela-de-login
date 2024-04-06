package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val nomeID = findViewById<EditText>(R.id.etCadastroNome)
        val userNameID = findViewById<EditText>(R.id.etCadastroUsername)
        val senhaID = findViewById<EditText>(R.id.etCadastroSenha)
        val confirmSenhaID = findViewById<EditText>(R.id.etCadastroConfirmacao)
        val btVoltar = findViewById<ImageView>(R.id.btVoltar)
        val btCadastrar = findViewById<Button>(R.id.btCadastrar)

        btCadastrar.setOnClickListener{
            val nome = nomeID.text.toString()
            val userName = userNameID.text.toString()
            val senha = senhaID.text.toString()
            val confirmSenha = confirmSenhaID.text.toString()

            if(nome != null && userName != null && senha != null && senha == confirmSenha){
                val user = UserModel()
                user.nome = nome
                user.username = userName
                user.senha = senha
                BD.users.add(user)
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val newIntent = Intent(this, MainActivity::class.java)
                startActivity(newIntent)
            }
        }

        btVoltar.setOnClickListener{
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
    }
}