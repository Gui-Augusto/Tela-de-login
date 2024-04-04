package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculadoraActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)

        val btSomar = findViewById<Button>(R.id.btSomar)
        val btSubtrair = findViewById<Button>(R.id.btSubtrair)
        val btDividir = findViewById<Button>(R.id.btDividir)
        val btMultiplicar = findViewById<Button>(R.id.btMultiplicar)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        var operacao = ""

        btSomar.setOnClickListener {
            operacao = "+"
        }
        btSubtrair.setOnClickListener {
            operacao = "-"
        }
        btDividir.setOnClickListener {
            operacao = "/"
        }
        btMultiplicar.setOnClickListener {
            operacao = "*"
        }

        val btCalcular = findViewById<Button>(R.id.btCalcular)

        btCalcular.setOnClickListener{

            val num1String = etNum1.text.toString()
            val num2String = etNum2.text.toString()

            if (operacao != "") {
                if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                    var result = 0.0

                    if (operacao == "+")
                        result = num1String.toDouble() + num2String.toDouble()
                    else if (operacao == "-")
                        result = num1String.toDouble() - num2String.toDouble()
                    else if (operacao == "/")
                        result = num1String.toDouble() / num2String.toDouble()
                    else if (operacao == "*")
                        result = num1String.toDouble() * num2String.toDouble()

                    tvResult.text = "O Resultado é: " + result

                } else {
                    Toast.makeText(this, "Informe os 2 numeros para continuar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Selecione a operação para continuar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}