package ru.markkuzi.mycocktails.presentation

import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

class CocktailDomainToUi : Cocktail.Mapper<CocktailsListUi> {
    override fun map(
        id: Int,
        name: String,
        description: String,
        ingredients: String,
        recipe: String,
        imageUri: String
    ): CocktailsListUi {
        return CocktailsListUi(
            id = id,
            name = name,
            imageUri = imageUri,
        )
    }
}