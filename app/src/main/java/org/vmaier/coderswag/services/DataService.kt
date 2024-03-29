package org.vmaier.coderswag.services

import org.vmaier.coderswag.model.Category
import org.vmaier.coderswag.model.Product

object DataService {

    val categories = listOf(
        Category("Shirts", "shirtimage"),
        Category("Hoodies", "hoodieimage"),
        Category("Hats", "hatimage"),
        Category("Digital", "digitalgoodsimage")
    )

    private val hats = listOf(
        Product("Devslopes Graphic Beanie", "$18", "hat1"),
        Product("Devslopes Hat Black", "$20", "hat2"),
        Product("Devslopes Hat White", "$18", "hat3"),
        Product("Devslopes Hat Snapback", "$22", "hat4")
    )

    private val hoodies = listOf(
        Product("Devslopes Hoodie Gray", "$28", "hoodie1"),
        Product("Devslopes Hoodie Red", "$32", "hoodie2"),
        Product("Devslopes Gray Hoodie", "$28", "hoodie3"),
        Product("Devslopes Black Hoodie", "$28", "hoodie4")
    )

    private val shirts = listOf(
        Product("Devslopes Shirt Black", "$18", "shirt1"),
        Product("Devslopes Badge Light Gray", "$20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "$22", "shirt3"),
        Product("Devslopes Hustle", "$22", "shirt4"),
        Product("Kickflip Studios", "$18", "shirt5")
    )

    private val digitalGoods = listOf<Product>()

    fun getProducts(category: String?) : List<Product> {
        return when(category) {
            "Shirts" -> shirts
            "Hats" -> hats
            "Hoodies" -> hoodies
            "Digital" -> digitalGoods
            else -> emptyList()
        }
    }
}