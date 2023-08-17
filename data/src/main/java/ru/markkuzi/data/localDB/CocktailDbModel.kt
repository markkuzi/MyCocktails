package ru.markkuzi.data.localDB

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CocktailDbModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cocktailId")
    val id: Int,
    @ColumnInfo(name = "cocktailName")
    val name: String,
    @ColumnInfo(name = "cocktailDescription")
    val description: String,
    @ColumnInfo(name = "cocktailIngredients")
    val ingredients: String,
    @ColumnInfo(name = "cocktailRecipe")
    val recipe: String,
    @ColumnInfo(name = "cocktailImage")
    val imageUri: String,
) {
    interface Mapper<T> {
        fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: String,
            recipe: String,
            imageUri: String,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name, description, ingredients, recipe, imageUri)

}