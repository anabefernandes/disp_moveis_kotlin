package br.edu.fatecpg.novamenteduastelas.dao

import br.edu.fatecpg.novamenteduastelas.model.Usuario

class UsuarioDao {
    companion object {
        private var usuario: Usuario = Usuario()
        fun definirUsuario(usuarioRecebido: Usuario) {
            Companion.usuario = usuarioRecebido
        }

        fun retornarUsuario(): Usuario {
            return Companion.usuario
        }
    }
}
