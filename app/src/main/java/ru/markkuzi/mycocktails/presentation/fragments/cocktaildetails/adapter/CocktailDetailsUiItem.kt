package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter

sealed class CocktailDetailsUiItem {

    data class UiCocktailDetailsImageTitleItem(
        val imageTitle: ImageTitleCocktailUi,
    ) : CocktailDetailsUiItem()

    data class UiCocktailDescriptionItem(val description: String) : CocktailDetailsUiItem()

    data class UiCocktailIngredientsListItem(val ingredients: List<String>) :
        CocktailDetailsUiItem()

    data class UiCocktailRecipeItem(val recipe: String) : CocktailDetailsUiItem()

}

