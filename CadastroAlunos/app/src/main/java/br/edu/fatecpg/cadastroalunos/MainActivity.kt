package br.edu.fatecpg.cadastroalunos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.cadastroalunos.dao.UserDao
import br.edu.fatecpg.cadastroalunos.model.User

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
                val usuario = User(nome)
                UserDao.definirUsuario(usuario)

                val intent = Intent(this, AlunosActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Digite o nome.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
