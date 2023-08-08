package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

interface EditCocktailUseCase {

    fun editCocktail(cocktail: Cocktail)

    class Base(private val repository: CocktailsRepository) : EditCocktailUseCase {
        override fun editCocktail(cocktail: Cocktail) {
            repository.editCocktail(cocktail)
        }
    }
}