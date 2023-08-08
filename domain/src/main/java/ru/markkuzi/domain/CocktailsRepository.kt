package ru.markkuzi.domain

import ru.markkuzi.domain.entities.Cocktail

interface CocktailsRepository {

    fun getCocktails(): List<Cocktail>

    fun createNewCocktail(cocktail: Cocktail)

    fun editCocktail(cocktail: Cocktail)

    fun deleteCocktailById(cocktailId: Int)
}