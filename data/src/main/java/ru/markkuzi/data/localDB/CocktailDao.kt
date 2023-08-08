package ru.markkuzi.data.localDB

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface CocktailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cocktailDbModel: CocktailDbModel)

    @Query("SELECT * FROM cocktails ORDER BY cocktailId ASC")
    suspend fun getCocktails(): List<CocktailDbModel>

    @Query("SELECT * FROM cocktails WHERE cocktailId == :cocktailId")
    suspend fun getCocktailDetails(cocktailId: Int): CocktailDbModel

    @Query("DELETE FROM cocktails WHERE cocktailId == :cocktailId")
    suspend fun deleteCocktailById(cocktailId: Int)

}