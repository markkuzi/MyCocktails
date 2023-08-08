package ru.markkuzi.domain.entities

data class Cocktail(
    private val id: Int,
    private val name: String,
    private val description: String,
    private val ingredients: String,
    private val recipe: String,
)  {
    interface Mapper<T> {
        fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: String,
            recipe: String,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name, description, ingredients, recipe)

}
