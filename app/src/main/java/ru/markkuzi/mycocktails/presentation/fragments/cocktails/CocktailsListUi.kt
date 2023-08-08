package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import ru.markkuzi.mycocktails.presentation.Mapper

data class CocktailsListUi(
    private val id: Int,
    private val name: String,
    private val image: Int,
) : Mapper<Boolean, CocktailsListUi> {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name, image)

    interface Mapper<T> {
        fun map(id: Int, name: String, image: Int): T
    }

    override fun map(source: CocktailsListUi): Boolean {
        return source.id == id
    }
}