package br.edu.fatecpg.calculoimc.dao

import br.edu.fatecpg.calculoimc.model.Imc

class ImcDao {
    companion object {
        private var imc: Imc? = null

        fun definirImc(imcRecebido: Imc) {
            imc = imcRecebido
        }

        fun retornarImc(): Imc {
            return imc ?: Imc(0.0, 0.0, 0.0)
        }
    }
}