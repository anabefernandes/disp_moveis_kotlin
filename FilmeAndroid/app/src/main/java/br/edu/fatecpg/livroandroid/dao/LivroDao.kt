package br.edu.fatecpg.livroandroid.dao

import br.edu.fatecpg.livroandroid.model.Livro

class LivroDao {
    companion object {
        private val livros = mutableListOf<Livro> ()
    }

    fun addUser(user:Livro){
        livros.add(user)
    }

    fun getUsers():List<Livro>{
        return livros
    }
}
