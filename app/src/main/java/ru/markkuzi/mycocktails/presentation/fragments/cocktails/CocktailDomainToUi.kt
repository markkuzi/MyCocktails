package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import ru.markkuzi.domain.entities.Cocktail

class CocktailDomainToUi : Cocktail.Mapper<CocktailsListUi> {
    override fun map(
        id: Int,
        name: String,
        description: String,
        ingredients: List<String>,
        recipe: String,
        imageUri: String,
    ): CocktailsListUi {
        return CocktailsListUi(
            id = id,
            name = name,
            imageUri = imageUri,
        )
    }
}