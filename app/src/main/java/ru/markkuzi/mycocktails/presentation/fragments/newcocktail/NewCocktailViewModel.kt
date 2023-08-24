package ru.markkuzi.mycocktails.presentation.fragments.newcocktail

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.domain.usecases.CreateNewCocktailUseCase
import ru.markkuzi.mycocktails.presentation.fragments.newcocktail.adapter.Ingredient
import javax.inject.Inject

@HiltViewModel
class NewCocktailViewModel @Inject constructor(
    private val addNewCocktailUseCase: CreateNewCocktailUseCase,
) : ViewModel() {

    private var _ingredients = MutableLiveData<List<Ingredient>>()
    val ingredients: LiveData<List<Ingredient>>
        get() = _ingredients

    private var countIngredients = 0

    private val listIngredients = mutableListOf<Ingredient>()

    fun addIngredient(ingredient: String) {
        if (ingredient.isNotEmpty()) {
            listIngredients.add(Ingredient(countIngredients, ingredient))
            countIngredients++
            _ingredients.value = listIngredients.toList()
        }
    }

    fun saveCocktail(name: String, description: String, recipe: String, imageUri: Uri) {
        viewModelScope.launch {
            addNewCocktailUseCase.createNewCocktail(
                Cocktail(
                    0,
                    name = name,
                    description = description,
                    ingredients = listIngredients.map { it.name }.toList(),
                    recipe = recipe,
                    imageUri = imageUri.toString(),
                )
            )
            listIngredients.clear()
        }
    }
}