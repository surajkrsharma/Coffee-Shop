package org.example.project

enum class Category(val value: String) {
    AllCoffee("All Coffee"),
    ColdCoffee("Cold Coffee"),
    HotCoffee("Hot Coffee"),
    Latte("Latte"),
    Americano("Americano"),
}

fun getAllCategory(): List<Category>{
    return listOf(Category.AllCoffee, Category.ColdCoffee, Category.HotCoffee,Category.Latte, Category.Americano)
}

fun getCategory(value: String): Category? {
    val map = Category.entries.associateBy(Category::value)
    return map[value]
}