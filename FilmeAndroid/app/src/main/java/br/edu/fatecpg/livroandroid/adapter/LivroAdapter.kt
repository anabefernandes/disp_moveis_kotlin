package br.edu.fatecpg.livroandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.livroandroid.R
import br.edu.fatecpg.livroandroid.model.Livro

class LivroAdapter(private val livros:List<Livro>)
    : RecyclerView.Adapter<LivroAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var txvTitulo = itemView.findViewById<TextView>(R.id.txv_titulo)
        var txvCategoria = itemView.findViewById<TextView>(R.id.txv_categoria)
        var txvNota = itemView.findViewById<TextView>(R.id.txv_nota)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_livro,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return livros.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = livros[position]
        holder.txvTitulo.text = user.titulo
        holder.txvCategoria.text = user.categoria
        holder.txvNota.text = String.format("%.2f", user.nota)
    }

}
