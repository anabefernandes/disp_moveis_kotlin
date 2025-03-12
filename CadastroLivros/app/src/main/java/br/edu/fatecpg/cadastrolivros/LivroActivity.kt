package br.edu.fatecpg.cadastrolivros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_livro)

        val fabSair = findViewById<Button>(R.id.fab_sair)
        val txtTitulo = findViewById<TextView>(R.id.txt_titulo)
        val txtAutor = findViewById<TextView>(R.id.txt_autor)

        val titulo = intent.getStringExtra("titulo")
        val autor = intent.getStringExtra("autor")

        txtTitulo.text = "Título: $titulo"
        txtAutor.text = "Autor: $autor"

        fabSair.setOnClickListener {
            finish()
        }

    }
}