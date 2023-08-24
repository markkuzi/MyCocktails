package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter

import ru.markkuzi.domain.entities.Cocktail

interface CocktailDetailsItemsCreator {

    fun createUiItems(
        cocktail: Cocktail,
    ): List<CocktailDetailsUiItem>

    class Base(
        private val imageTitleMapper: Cocktail.Mapper<ImageTitleCocktailUi>,
        private val listDescriptionMapper: DescriptionUi,
        private val listIngredientsMapper: Cocktail.Mapper<List<String>>,
        private val listRecipeMapper: RecipeUi,
    ) : CocktailDetailsItemsCreator {
        override fun createUiItems(cocktail: Cocktail): List<CocktailDetailsUiItem> {

            val list = mutableListOf<CocktailDetailsUiItem>()

            list.add(
                CocktailDetailsUiItem.UiCocktailDetailsImageTitleItem(
                    cocktail.map(
                        imageTitleMapper
                    )
                )
            )
            list.add(
                CocktailDetailsUiItem.UiCocktailDescriptionItem(
                    cocktail.map(listDescriptionMapper)
                )
            )
            list.add(
                CocktailDetailsUiItem.UiCocktailIngredientsListItem(
                    cocktail.map(listIngredientsMapper)
                )
            )
            list.add(
                CocktailDetailsUiItem.UiCocktailRecipeItem(
                    cocktail.map(listRecipeMapper)
                )
            )

            return list.toList()
        }
    }
}