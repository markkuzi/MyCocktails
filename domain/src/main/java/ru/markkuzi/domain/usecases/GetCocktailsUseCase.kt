package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface GetCocktailsUseCase {

    suspend fun getCocktails(): List<Cocktail>

    class Base(private val repository: CocktailsRepository) : GetCocktailsUseCase {
        override suspend fun getCocktails(): List<Cocktail> {
            return repository.getCocktails()
        }
    }

}