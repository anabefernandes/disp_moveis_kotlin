package br.edu.fatecpg.novamenteduastelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.novamenteduastelas.dao.UsuarioDao
import br.edu.fatecpg.novamenteduastelas.model.Usuario

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtTensao = findViewById<EditText>(R.id.edt_tensao)
        val edtCorrente = findViewById<EditText>(R.id.edt_corrente)
        val edtResistencia = findViewById<EditText>(R.id.edt_resistencia)
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)

        btnEntrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val tensao = edtTensao.text.toString()
            val corrente = edtCorrente.text.toString()
            val resistencia = edtResistencia.text.toString()

            if (nome.length > 2 && tensao.isNotEmpty() && resistencia.isNotEmpty() && corrente.isNotEmpty()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("Preencha apenas dois campos para o calculo.")
                val dialog = builder.create()
                dialog.show()
            } else if (nome.length > 2 && tensao.isNotEmpty() && resistencia.isNotEmpty()) {
                val calculoCorrente = tensao.toDouble() / resistencia.toDouble()
                UsuarioDao.definirUsuario(Usuario(nome, calculoCorrente))
                startActivity(Intent(this, UsuarioActivity::class.java))
            } else if (nome.length > 2 && tensao.isNotEmpty() && corrente.isNotEmpty()) {
                val calculoResistencia = tensao.toDouble() / corrente.toDouble()
                UsuarioDao.definirUsuario(Usuario(nome, calculoResistencia))
                startActivity(Intent(this, UsuarioActivity::class.java))
            } else if (nome.length > 2 && resistencia.isNotEmpty() && corrente.isNotEmpty()) {
                val calculoTensao = corrente.toDouble() * resistencia.toDouble()
                UsuarioDao.definirUsuario(Usuario(nome, calculoTensao))
                startActivity(Intent(this, UsuarioActivity::class.java))
            } else {
                Toast.makeText(this, "Preencha dois campos para calcular", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

