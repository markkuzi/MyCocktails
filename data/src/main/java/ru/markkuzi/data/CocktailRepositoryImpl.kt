package ru.markkuzi.data

import ru.markkuzi.data.localDB.CocktailDao
import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail

class CocktailRepositoryImpl(private val cocktailDao: CocktailDao) : CocktailsRepository {
    override fun getCocktails(): List<Cocktail> {
        return cocktailDao.getCocktails() //TODO add mapper
    }

    override fun getCocktailDetails(cocktailId: Int) { //TODO add fun in domain
        cocktailDao.getCocktailDetails(cocktailId) //TODO add mapper
    }

    override fun createNewCocktail(cocktail: Cocktail) {
        cocktailDao.insert(cocktail) //TODO add mapper
    }

    override fun editCocktail(cocktail: Cocktail) {
        cocktailDao.insert(cocktail) //TODO add mapper
    }

    override fun deleteCocktailById(cocktailId: Int) {
        cocktailDao.deleteCocktailById(cocktailId) //TODO add mapper
    }
}