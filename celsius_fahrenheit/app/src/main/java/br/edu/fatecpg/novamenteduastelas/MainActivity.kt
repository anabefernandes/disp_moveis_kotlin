package br.edu.fatecpg.novamenteduastelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.novamenteduastelas.dao.UsuarioDao
import br.edu.fatecpg.novamenteduastelas.model.Usuario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtCelsius = findViewById<EditText>(R.id.edt_celsius)
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)

        btnEntrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val celsius = edtCelsius.text.toString()

            try {
                if (nome.length > 2 && celsius != "") {
                    //formula (valorCelsius * 9/5) + 32
                    val valorCelsius = celsius.toDouble()
                    val temperatura = (valorCelsius * 9 / 5) + 32

                    val usuario = Usuario(nome, temperatura)
                    UsuarioDao.definirUsuario(usuario)

                    val intent = Intent(this, UsuarioActivity::class.java)
//                    intent.putExtra("usuarioNome", nome)
//                    intent.putExtra("fahrenheit", temperatura)
                    startActivity(intent)

                } else {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Erro")
                    builder.setMessage("Nome ou temperatura informados são inválidos.")
                    val dialog = builder.create()
                    dialog.show()
                }
            } catch (e: Exception) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("Erro: ${e.message}")
                val dialog = builder.create()
                dialog.show()
            }
        }
    }
}

