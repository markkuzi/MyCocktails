package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface GetCocktailsUseCase {

    fun getCocktails(): List<Cocktail>

    class Base(private val repository: CocktailsRepository) : GetCocktailsUseCase {
        override fun getCocktails(): List<Cocktail> {
            return repository.getCocktails()
        }
    }

}