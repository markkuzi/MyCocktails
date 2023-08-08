package ru.markkuzi.data.localDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CocktailDbModel(
    @PrimaryKey
    @ColumnInfo(name = "cocktailId")
    val id: Int,
    @ColumnInfo(name = "cocktailName")
    val name: String,
    @ColumnInfo(name = "cocktailDescription")
    val description: String,
    @ColumnInfo(name = "cocktailIngredients")
    val ingredients: List<String>,
    @ColumnInfo(name = "cocktailRecipe")
    val recipe: String,
) {
    interface Mapper<T> {
        fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: List<String>,
            recipe: String,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name, description, ingredients, recipe)

}