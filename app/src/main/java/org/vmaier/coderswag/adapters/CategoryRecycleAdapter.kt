package org.vmaier.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.vmaier.coderswag.R
import org.vmaier.coderswag.model.Category

class CategoryRecycleAdapter(val context : Context, val categories : List<Category>, val itemClick : (Category) -> Unit) :
    RecyclerView.Adapter<CategoryRecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    inner class ViewHolder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {

            val resourceId = context.resources.getIdentifier(category.image,
                "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title

            itemView.setOnClickListener {
                itemClick(category)
            }
        }
    }
}