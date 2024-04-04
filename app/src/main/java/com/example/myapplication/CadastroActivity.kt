package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val nomeID = findViewById<EditText>(R.id.etCadastroNome)
        val userNameID = findViewById<EditText>(R.id.etCadastroUsername)
        val senhaID = findViewById<EditText>(R.id.etCadastroSenha)
        val confirmSenhaID = findViewById<EditText>(R.id.etCadastroConfirmacao)

        val btCadastrar = findViewById<Button>(R.id.btCadastrar)

        btCadastrar.setOnClickListener{
            var nome = nomeID.text.toString()
            var userName = userNameID.text.toString()
            var senha = senhaID.text.toString()
            var confirmSenha = confirmSenhaID.text.toString()

            if(nome != null && userName != null && senha != null && senha == confirmSenha){
                var user = UserModel()
                user.nome = nome
                user.username = userName
                user.senha = senha
                BD.users.add(user)
            }
        }
    }
}