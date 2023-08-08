package ru.markkuzi.domain.entities

data class Cocktail(
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val recipe: String,
)
