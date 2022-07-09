package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProductsDao {

    fun addProduct(produto: Produto) {
      produtos.add(produto)
    }

    fun searchProduct(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}