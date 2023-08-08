package ru.markkuzi.data

import ru.markkuzi.data.localDB.CocktailDao
import ru.markkuzi.data.localDB.CocktailDbModel
import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailDao: CocktailDao,
    private val mapperToDomain: CocktailDbModel.Mapper<Cocktail>,
    private val mapperToData: Cocktail.Mapper<CocktailDbModel>,
) : CocktailsRepository {
    override suspend fun getCocktails(): List<Cocktail> {
        return cocktailDao.getCocktails().map { it.map(mapperToDomain) }
    }

    override suspend fun getCocktailDetails(cocktailId: Int): Cocktail {
        return cocktailDao.getCocktailDetails(cocktailId).map(mapperToDomain)
    }

    override suspend fun createNewCocktail(cocktail: Cocktail) {
        cocktailDao.insert(cocktail.map(mapperToData))
    }

    override suspend fun editCocktail(cocktail: Cocktail) {
        cocktailDao.insert(cocktail.map(mapperToData))
    }

    override suspend fun deleteCocktailById(cocktailId: Int) {
        cocktailDao.deleteCocktailById(cocktailId)
    }
}