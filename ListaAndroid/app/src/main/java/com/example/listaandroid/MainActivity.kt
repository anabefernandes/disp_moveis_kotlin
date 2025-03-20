package com.example.listaandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listaandroid.dao.UserDao
import com.example.listaandroid.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtCategoria = findViewById<EditText>(R.id.edt_categoria)
        val edtNota = findViewById<EditText>(R.id.edt_nota)
        val btnSave:Button = findViewById(R.id.btn_save)
        val fabList:FloatingActionButton = findViewById(R.id.fab_list)
        val dao = UserDao()

        btnSave.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val categoria = edtCategoria.text.toString()
            val nota = edtNota.text.toString().toDouble()

            val user = User(titulo, categoria, nota)
            dao.addUser(user)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Criado com sucesso")
            val dialog = builder.create()
            dialog.show()

            edtTitulo.text.clear()
            edtCategoria.text.clear()
            edtNota.text.clear()
        }

        fabList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }


    }
}