package br.edu.fatecpg.cadastrolivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val autor = edtAutor.text.toString()

            if (titulo.isNotEmpty() && autor.isNotEmpty()) {
                val intent = Intent(this, LivroActivity::class.java)
                intent.putExtra("titulo", titulo)
                intent.putExtra("autor", autor)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }


        }
    }
}