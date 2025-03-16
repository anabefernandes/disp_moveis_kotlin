package br.edu.fatecpg.novamenteduastelas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.novamenteduastelas.dao.UsuarioDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UsuarioActivity : AppCompatActivity(R.layout.activity_usuario) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fabSair = findViewById<Button>(R.id.fabSair)
        val txvNome = findViewById<TextView>(R.id.txv_nome)
        val txvTemperatura = findViewById<TextView>(R.id.txv_temperatura)

        val usuario = UsuarioDao.obterUsuario()

//        val nomeUsuario = intent.getStringExtra("usuarioNome")
//        val fahrenheit = intent.getDoubleExtra("fahrenheit", 0.0)

//        txvNome.text = "Olá, $nomeUsuario!"
//        txvTemperatura.text = "A temperatura em Fahrenheit é: $fahrenheit"

        if (usuario != null) {
            txvNome.text = "Olá, ${usuario.nome}!"
            txvTemperatura.text = "A temperatura em Fahrenheit é: ${usuario.temperatura}"
        }else {
            txvNome.text = "Usuário não encontrado."
            txvTemperatura.text = ""
        }

        fabSair.setOnClickListener {
            finish()
        }
    }
}