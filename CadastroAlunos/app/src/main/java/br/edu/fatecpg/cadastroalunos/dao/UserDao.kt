package br.edu.fatecpg.cadastroalunos.dao

import br.edu.fatecpg.cadastroalunos.model.User

object UserDao {
    private var usuario: User? = null

    fun definirUsuario(user: User) {
        usuario = user
    }

    fun retornarUsuario(): User? {
        return usuario
    }
}
