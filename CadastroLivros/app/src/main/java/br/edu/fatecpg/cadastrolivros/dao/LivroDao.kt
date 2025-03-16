package br.edu.fatecpg.cadastrolivros.dao

import br.edu.fatecpg.cadastrolivros.model.Livro

class LivroDao {
    companion object {
        private var livro: Livro = Livro() // Agora não dá erro

        fun definirLivro(livroRecebido: Livro) {
            livro = livroRecebido
        }

        fun retornarLivro(): Livro {
            return livro
        }
    }
}
