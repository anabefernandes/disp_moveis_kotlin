package com.example.listaandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaandroid.adapter.UserAdapter
import com.example.listaandroid.dao.UserDao

class ListActivity : AppCompatActivity(R.layout.activity_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dao = UserDao()
        val users = dao.getUsers()
        Log.i("ListUsers", users.toString())

        val  rvUsers = findViewById<RecyclerView>(R.id.rv_users)

        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = UserAdapter(users)


    }
}