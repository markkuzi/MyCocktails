package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter

import androidx.core.net.toUri
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.presentation.ManageResources

interface CocktailDomainToDetailsUi {

    class ImageTitle : CocktailDomainToDetailsUi, Cocktail.Mapper<ImageTitleCocktailUi> {
        override fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: List<String>,
            recipe: String,
            imageUri: String,
        ) = ImageTitleCocktailUi(
            title = name,
            image = imageUri.toUri()
        )
    }

    class Description : CocktailDomainToDetailsUi, DescriptionUi {
        override fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: List<String>,
            recipe: String,
            imageUri: String,
        ) = description
    }

    class ListIngredients : CocktailDomainToDetailsUi, Cocktail.Mapper<List<String>> {
        override fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: List<String>,
            recipe: String,
            imageUri: String,
        ): List<String> {
            val list = mutableListOf<String>()
            ingredients.forEach {
                list.add(it)
                list.add("—")
            }
            list.removeLast()
            return list
        }
    }

    class Recipe(
        private val manageResources: ManageResources,
    ) : CocktailDomainToDetailsUi, RecipeUi {
        override fun map(
            id: Int,
            name: String,
            description: String,
            ingredients: List<String>,
            recipe: String,
            imageUri: String,
        ): String {
            return if (recipe.isEmpty())
                ""
            else {
                manageResources.string(R.string.recipe_for_description) + "\n" + recipe
            }
        }
    }
}

interface DescriptionUi : Cocktail.Mapper<String>
interface RecipeUi : Cocktail.Mapper<String>