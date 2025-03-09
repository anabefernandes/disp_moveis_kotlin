package br.edu.fatecpg.novamenteduastelas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.novamenteduastelas.dao.UsuarioDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usuario)


        val fabSair = findViewById<Button>(R.id.fabSair)
        val txvNome = findViewById<TextView>(R.id.txv_nome)
        val txvTemperatura = findViewById<TextView>(R.id.txv_result)

        val nomeUsuario = intent.getStringExtra("usuarioNome")
        val resultado = intent.getDoubleExtra("resultado", 0.0)

        txvNome.text = "Olá, $nomeUsuario!"
        txvTemperatura.text = "Resultado: $resultado"

        fabSair.setOnClickListener {
            finish()
        }
    }
}