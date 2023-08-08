package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.domain.usecases.GetCocktailsUseCase
import ru.markkuzi.mycocktails.R
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    private val getCocktailsUseCase: GetCocktailsUseCase,
    private val mapper: Cocktail.Mapper<CocktailsListUi>,
) : ViewModel() {

    private var _cocktails = MutableLiveData<List<CocktailsListUi>>()
    val cocktails: LiveData<List<CocktailsListUi>>
        get() = _cocktails

    fun getCocktails() {
        viewModelScope.launch {
            val uiCocktails = getCocktailsUseCase.getCocktails().map {
                it.map(mapper)
            }
            _cocktails.value = uiCocktails
        }

    }

    fun navigate(navController: NavController) {
        navController.navigate(R.id.action_cocktailsFragment_to_newCocktailFragment)
    }

}