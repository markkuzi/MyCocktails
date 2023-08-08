package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface EditCocktailUseCase {

    suspend fun editCocktail(cocktail: Cocktail)

    class Base(private val repository: CocktailsRepository) : EditCocktailUseCase {
        override suspend fun editCocktail(cocktail: Cocktail) {
            repository.editCocktail(cocktail)
        }
    }
}