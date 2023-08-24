package ru.markkuzi.data

import ru.markkuzi.data.localDB.CocktailDbModel
import ru.markkuzi.domain.entities.Cocktail

class CocktailDomainToData : Cocktail.Mapper<CocktailDbModel> {
    override fun map(
        id: Int,
        name: String,
        description: String,
        ingredients: List<String>,
        recipe: String,
        imageUri: String,
    ): CocktailDbModel {
        return CocktailDbModel(
            id = id,
            name = name,
            description = description,
            ingredients = ingredients.joinToString(separator = ","),
            recipe = recipe,
            imageUri = imageUri,
        )
    }
}