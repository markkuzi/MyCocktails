package ru.markkuzi.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CocktailDbModel::class], version = 1, exportSchema = false)
abstract class CocktailsDB : RoomDatabase() {
    abstract val cocktailDao: CocktailDao
}