package br.edu.fatecpg.calculoimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculoActivity : AppCompatActivity(R.layout.activity_calculo) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fabSair = findViewById<Button>(R.id.fab_sair)
        val txtResultado = findViewById<TextView>(R.id.txt_resultado)
        val txtImc = findViewById<TextView>(R.id.txt_imc)

        val imc = intent.getDoubleExtra("imc", 0.0)
        txtResultado.text = imc.toString()
        if (imc < 18.5) {
            txtImc.text = "Abaixo do peso."
        } else if (imc == 18.5 || imc < 25) {
            txtImc.text = "Peso normal."
        } else if (imc == 25.toDouble() || imc < 30) {
            txtImc.text = "Sobrepeso."
        } else if (imc == 30.toDouble() || imc < 40) {
            txtImc.text = "Obesidade."
        } else {
            txtImc.text = "Obesidade grave."
        }

        fabSair.setOnClickListener {
            finish()
        }
    }
}