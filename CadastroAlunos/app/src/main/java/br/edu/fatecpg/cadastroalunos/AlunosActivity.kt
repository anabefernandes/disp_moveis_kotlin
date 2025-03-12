package br.edu.fatecpg.cadastroalunos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class AlunosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alunos)

        val txtNome = findViewById<TextView>(R.id.txt_nome)
        val txtMatricula = findViewById<TextView>(R.id.txt_matricula)
        val btnGerarMatricula = findViewById<Button>(R.id.btn_gerar_matricula)
        val fabSair = findViewById<Button>(R.id.fab_sair)

        val nome = intent.getStringExtra("nome")
        txtNome.text = "Nome: $nome"

        btnGerarMatricula.setOnClickListener {
            val matricula = Random.nextInt(100000, 999999).toString()
            txtMatricula.text = "Matricula: $matricula"
        }

        fabSair.setOnClickListener {
            finish()
        }


    }
}