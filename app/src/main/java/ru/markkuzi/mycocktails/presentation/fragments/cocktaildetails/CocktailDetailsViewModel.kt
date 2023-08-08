package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.domain.usecases.DeleteCocktailByIdUseCase
import ru.markkuzi.domain.usecases.GetCocktailDetailsUseCase
import ru.markkuzi.mycocktails.presentation.fragments.newcocktail.adapter.Ingredient
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
    private val deleteCocktailByIdUseCase: DeleteCocktailByIdUseCase,
): ViewModel() {

    private var _ingredients = MutableLiveData<Cocktail>()
    val ingredients: LiveData<Cocktail>
        get() = _ingredients

    fun getCocktailDetails(cocktailId: Int) {
        viewModelScope.launch {
            val cocktail = getCocktailDetailsUseCase.getCocktailDetails(cocktailId)
            _ingredients.value = cocktail
        }
    }

    fun deleteCocktail(cocktailId: Int) {
        viewModelScope.launch {
            deleteCocktailByIdUseCase.deleteCocktailById(cocktailId)
        }
    }

}