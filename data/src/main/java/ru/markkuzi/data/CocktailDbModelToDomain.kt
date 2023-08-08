package ru.markkuzi.data

import ru.markkuzi.data.localDB.CocktailDbModel
import ru.markkuzi.domain.entities.Cocktail

class CocktailDbModelToDomain : CocktailDbModel.Mapper<Cocktail> {
    override fun map(
        id: Int,
        name: String,
        description: String,
        ingredients: List<String>,
        recipe: String,
    ): Cocktail {
        return Cocktail(
            id = id,
            name = name,
            description = description,
            ingredients = ingredients,
            recipe = recipe,
        )
    }
}