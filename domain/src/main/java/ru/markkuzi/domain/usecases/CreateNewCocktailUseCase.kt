package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface CreateNewCocktailUseCase {

    fun createNewCocktail(cocktail: Cocktail)

    class Base(private val repository: CocktailsRepository) : CreateNewCocktailUseCase {
        override fun createNewCocktail(cocktail: Cocktail) {
            repository.createNewCocktail(cocktail)
        }
    }
}