package br.edu.fatecpg.livroandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.livroandroid.adapter.LivroAdapter
import br.edu.fatecpg.livroandroid.dao.LivroDao

class LivroActivity : AppCompatActivity(R.layout.activity_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = LivroDao()
        val livros = dao.getUsers()
        Log.i("ListLivros", livros.toString())

        val  rvLivros = findViewById<RecyclerView>(R.id.rv_livros)

        rvLivros.layoutManager = LinearLayoutManager(this)
        rvLivros.adapter = LivroAdapter(livros)
    }
}