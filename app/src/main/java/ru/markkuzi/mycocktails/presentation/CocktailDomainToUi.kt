package ru.markkuzi.mycocktails.presentation

import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

class CocktailDomainToUi : Cocktail.Mapper<CocktailsListUi> {
    override fun map(
        id: Int,
        name: String,
        description: String,
        ingredients: List<String>,
        recipe: String,
    ): CocktailsListUi {
        return CocktailsListUi(
            id = id,
            name = name,
            image = 0,
        )
    }
}