package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProductsDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListProductsActivity : AppCompatActivity(R.layout.activity_list_products) {

    private val dao = ProductsDao()
    private val adapter = ListaProdutosAdapter(
        context = this, produtos = dao.searchProduct()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productList()
    }

    override fun onResume() {
        super.onResume()
        adapter.att(dao.searchProduct())
        addProductsFloatButton()
    }

    private fun productList() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    private fun addProductsFloatButton() {
        val floarActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floarActionButton.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}