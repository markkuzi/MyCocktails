package ru.markkuzi.mycocktails.presentation.fragments.editcocktail

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.domain.usecases.CreateNewCocktailUseCase
import ru.markkuzi.domain.usecases.GetCocktailDetailsUseCase
import javax.inject.Inject

@HiltViewModel
class EditCocktailViewModel @Inject constructor(
    private val addNewCocktailUseCase: CreateNewCocktailUseCase,
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
) : ViewModel() {

    private var ingredientsFromCocktail: String = ""

    private var _cocktail = MutableLiveData<Cocktail>()
    val cocktail: LiveData<Cocktail>
        get() = _cocktail

    fun getCocktail(cocktailId: Int) {
        viewModelScope.launch {
            val cocktailDetails = getCocktailDetailsUseCase.getCocktailDetails(cocktailId)
            _cocktail.value = cocktailDetails
            ingredientsFromCocktail = cocktailDetails.ingredients.joinToString { "," }
        }
    }

    fun saveCocktail(id: Int, name: String, description: String, recipe: String, imageUri: Uri) {
        viewModelScope.launch {
            addNewCocktailUseCase.createNewCocktail(
                Cocktail(
                    id,
                    name = name,
                    description = description,
                    ingredients = ingredientsFromCocktail.split(","),
                    recipe = recipe,
                    imageUri = imageUri.toString(),
                )
            )
        }
    }
}