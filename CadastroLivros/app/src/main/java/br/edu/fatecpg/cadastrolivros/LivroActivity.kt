package br.edu.fatecpg.cadastrolivros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.cadastrolivros.dao.LivroDao

class LivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_livro)

        val fabSair = findViewById<Button>(R.id.fab_sair)
        val txtTitulo = findViewById<TextView>(R.id.txt_titulo)
        val txtAutor = findViewById<TextView>(R.id.txt_autor)

        val livro = LivroDao.retornarLivro()

        txtTitulo.text = "Título: ${livro.titulo}"
        txtAutor.text = "Autor: ${livro.autor}"

        fabSair.setOnClickListener {
            finish()
        }

    }
}