package ru.markkuzi.domain.usecases

import ru.markkuzi.domain.CocktailsRepository

interface DeleteCocktailByIdUseCase {

    suspend fun deleteCocktailById(cocktailId: Int)

    class Base(private val repository: CocktailsRepository) : DeleteCocktailByIdUseCase {
        override suspend fun deleteCocktailById(cocktailId: Int) {
            repository.deleteCocktailById(cocktailId)
        }
    }
}