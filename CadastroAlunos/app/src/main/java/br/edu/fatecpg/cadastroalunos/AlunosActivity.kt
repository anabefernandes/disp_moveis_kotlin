package br.edu.fatecpg.cadastroalunos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.cadastroalunos.dao.UserDao
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

        val usuario = UserDao.retornarUsuario()

        if (usuario != null) {
            txtNome.text = "Nome: ${usuario.nome}"
        }

        btnGerarMatricula.setOnClickListener {
            usuario?.matricula = Random.nextInt(100000, 999999).toString()
            txtMatricula.text = "Matricula: ${usuario?.matricula}"
        }

        fabSair.setOnClickListener {
            finish()
        }
    }
}
