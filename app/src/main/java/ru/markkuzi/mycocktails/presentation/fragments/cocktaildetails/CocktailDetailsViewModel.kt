package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.markkuzi.domain.usecases.DeleteCocktailByIdUseCase
import ru.markkuzi.domain.usecases.GetCocktailDetailsUseCase
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.CocktailDetailsItemsCreator
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.CocktailDetailsUiItem
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
    private val deleteCocktailByIdUseCase: DeleteCocktailByIdUseCase,
    private val cocktailDetailsItemsCreator: CocktailDetailsItemsCreator,
) : ViewModel() {

    private var _cocktailDetails = MutableLiveData<List<CocktailDetailsUiItem>>()
    val cocktailDetails: LiveData<List<CocktailDetailsUiItem>>
        get() = _cocktailDetails

    fun getCocktailDetails(cocktailId: Int) {
        viewModelScope.launch {
            val cocktail = getCocktailDetailsUseCase.getCocktailDetails(cocktailId)
            _cocktailDetails.value = cocktailDetailsItemsCreator.createUiItems(cocktail)
        }
    }

    fun deleteCocktail(cocktailId: Int) {
        viewModelScope.launch {
            deleteCocktailByIdUseCase.deleteCocktailById(cocktailId)
        }
    }

}