package ru.markkuzi.domain

import ru.markkuzi.domain.entities.Cocktail

interface CocktailsRepository {

    suspend fun getCocktails(): List<Cocktail>

    suspend fun getCocktailDetails(cocktailId: Int): Cocktail

    suspend fun createNewCocktail(cocktail: Cocktail)

    suspend fun editCocktail(cocktail: Cocktail)

    suspend fun deleteCocktailById(cocktailId: Int)
}