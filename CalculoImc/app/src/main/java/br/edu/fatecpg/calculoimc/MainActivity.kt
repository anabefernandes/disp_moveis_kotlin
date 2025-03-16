package br.edu.fatecpg.calculoimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.calculoimc.dao.ImcDao
import br.edu.fatecpg.calculoimc.model.Imc

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val txtAltura = findViewById<TextView>(R.id.txt_altura)
        val txtPeso = findViewById<TextView>(R.id.txt_peso)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener{
            val altura = txtAltura.text.toString().toDouble()
            val peso = txtPeso.text.toString().toDouble()

            if (altura != 0.0 || peso != 0.0) {
                val calcImc = peso / (altura * altura)
                val imc = Imc(peso, altura, calcImc)

                ImcDao.definirImc(imc)

                val intent = Intent(this, CalculoActivity::class.java)
                startActivity(intent)
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("Preencha os campos para o calculo.")
                val dialog = builder.create()
                dialog.show()
            }

        }

    }
}