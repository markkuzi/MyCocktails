package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository

interface DeleteCocktailByIdUseCase {

    fun deleteCocktailById(cocktailId: Int)

    class Base(private val repository: CocktailsRepository) : DeleteCocktailByIdUseCase {
        override fun deleteCocktailById(cocktailId: Int) {
            repository.deleteCocktailById(cocktailId)
        }
    }
}