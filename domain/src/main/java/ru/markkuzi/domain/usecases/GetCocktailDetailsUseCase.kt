package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface GetCocktailDetailsUseCase {

    fun getCocktailDetails(cocktailId: Int): Cocktail

    class Base(private val repository: CocktailsRepository) : GetCocktailDetailsUseCase {
        override fun getCocktailDetails(cocktailId: Int): Cocktail {
            return repository.getCocktailDetails(cocktailId)
        }
    }
}