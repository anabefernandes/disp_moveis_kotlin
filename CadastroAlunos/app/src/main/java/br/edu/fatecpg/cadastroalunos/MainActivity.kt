package br.edu.fatecpg.cadastroalunos

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

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            if (nome.isNotEmpty()) {
                val intent = Intent(this, AlunosActivity::class.java)
                intent.putExtra("nome", nome)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Digite o nome.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}