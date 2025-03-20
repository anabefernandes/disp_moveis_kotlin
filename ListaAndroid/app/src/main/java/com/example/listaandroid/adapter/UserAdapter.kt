package com.example.listaandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listaandroid.R
import com.example.listaandroid.model.User

class UserAdapter(private val users:List<User>)
    :RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var txvTitulo = itemView.findViewById<TextView>(R.id.txv_titulo)
        var txvCategoria = itemView.findViewById<TextView>(R.id.txv_categoria)
        var txvNota = itemView.findViewById<TextView>(R.id.txv_nota)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.txvTitulo.text = user.titulo
        holder.txvCategoria.text = user.categoria
        holder.txvNota.text = String.format("%.2f", user.nota)
    }

}