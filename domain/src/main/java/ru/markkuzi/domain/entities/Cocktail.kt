package ru.markkuzi.domain.entities

data class Cocktail(
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: String,
    val recipe: String,
    val imageUri: String,
) {
    interface Mapper<T> {
        fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: String,
            recipe: String,
            imageUri: String,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T =
        mapper.map(id, name, description, ingredients, recipe, imageUri)

}
