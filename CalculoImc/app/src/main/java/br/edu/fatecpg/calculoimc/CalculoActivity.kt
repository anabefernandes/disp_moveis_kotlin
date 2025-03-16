package br.edu.fatecpg.calculoimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.calculoimc.dao.ImcDao

class CalculoActivity : AppCompatActivity(R.layout.activity_calculo) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fabSair = findViewById<Button>(R.id.fab_sair)
        val txtResultado = findViewById<TextView>(R.id.txt_resultado)
        val txtImc = findViewById<TextView>(R.id.txt_imc)

        val imc = ImcDao.retornarImc()
        val valorImc = imc.calcImc

        txtResultado.text = "IMC: $valorImc"

        if (valorImc < 18.5) {
            txtImc.text = "Abaixo do peso."
        } else if (valorImc >= 18.5 && valorImc < 25) {
            txtImc.text = "Peso normal."
        } else if (valorImc >= 25 && valorImc < 30) {
            txtImc.text = "Sobrepeso."
        } else if (valorImc >= 30 && valorImc < 40) {
            txtImc.text = "Obesidade."
        } else {
            txtImc.text = "Obesidade grave."
        }

        fabSair.setOnClickListener {
            finish()
        }
    }
}