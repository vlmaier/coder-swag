package org.vmaier.coderswag.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import org.vmaier.coderswag.R
import org.vmaier.coderswag.adapters.ProductAdapter
import org.vmaier.coderswag.databinding.ActivityProductsBinding
import org.vmaier.coderswag.services.DataService
import org.vmaier.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        binding = ActivityProductsBinding.inflate(layoutInflater)

        val category = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductAdapter(this, DataService.getProducts(category))
        binding.productListView.adapter = adapter

        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp

        var spanCount = if (orientation == Configuration.ORIENTATION_LANDSCAPE) 3 else 2
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        binding.productListView.layoutManager = layoutManager
        binding.productListView.setHasFixedSize(true)
    }
}
