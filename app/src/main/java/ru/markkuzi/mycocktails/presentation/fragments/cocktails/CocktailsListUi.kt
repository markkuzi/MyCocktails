package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import ru.markkuzi.mycocktails.presentation.Mapper

data class CocktailsListUi(
    val id: Int,
    private val name: String,
    private val imageUri: String,
) : Mapper<Boolean, CocktailsListUi> {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name, imageUri)

    interface Mapper<T> {
        fun map(id: Int, name: String, imageUri: String): T
    }

    override fun map(source: CocktailsListUi): Boolean {
        return source.id == id
    }
}