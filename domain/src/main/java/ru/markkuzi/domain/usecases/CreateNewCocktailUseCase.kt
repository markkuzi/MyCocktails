package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface CreateNewCocktailUseCase {

    suspend fun createNewCocktail(cocktail: Cocktail)

    class Base(private val repository: CocktailsRepository) : CreateNewCocktailUseCase {
        override suspend fun createNewCocktail(cocktail: Cocktail) {
            repository.createNewCocktail(cocktail)
        }
    }
}