package ru.markkuzi.mycocktails.presentation.fragments.newcocktail

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
    private val addNewCocktailUseCase: CreateNewCocktailUseCase
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
            _ingredients.value = listIngredients
        }
    }

    fun saveCocktail(name: String, description: String, recipe: String) {
        viewModelScope.launch {
            addNewCocktailUseCase.createNewCocktail(Cocktail(
                0,
                name = name,
                description = description,
                ingredients = listIngredients.joinToString { "\n-\n" },
                recipe = recipe,
            ))
            listIngredients.clear()
        }
    }
}