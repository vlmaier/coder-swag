package org.vmaier.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.vmaier.coderswag.R
import org.vmaier.coderswag.adapters.CategoryRecycleAdapter
import org.vmaier.coderswag.services.DataService
import org.vmaier.coderswag.utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productsActivity = Intent(this, ProductsActivity::class.java)
            productsActivity.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productsActivity)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
