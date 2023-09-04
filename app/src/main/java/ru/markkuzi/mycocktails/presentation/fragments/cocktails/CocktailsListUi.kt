package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import ru.markkuzi.mycocktails.presentation.Matches

data class CocktailsListUi(
    private val id: Int,
    private val name: String,
    private val imageUri: String,
) : Matches<CocktailsListUi>, CocktailId {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name, imageUri)

    interface Mapper<T> {
        fun map(id: Int, name: String, imageUri: String): T
    }

    override fun matches(data: CocktailsListUi): Boolean {
        return data.id == id
    }

    override fun getId(): Int {
        return id
    }
}

interface CocktailId {

    fun getId(): Int

}