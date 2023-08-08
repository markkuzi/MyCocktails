package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailDetailsBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsViewModel


@AndroidEntryPoint
class CocktailDetailsFragment : Fragment(R.layout.fragment_cocktail_details) {

    private val viewModel: CocktailDetailsViewModel by viewModels()
    private val binding by viewBinding(FragmentCocktailDetailsBinding::bind)
    private var cocktailId : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCocktailDetails(cocktailId)

        viewModel.ingredients.observe(viewLifecycleOwner) {
            binding.tvTitle.text = it.name
            binding.tvDescription.text = it.description
            binding.tvIngredients.text = it.ingredients
            binding.tvRecipe.text = it.recipe
        }

    }

    private fun parseArgs() {
        requireArguments().getInt(KEY_DETAIL)?.let {
            cocktailId = it
        }
    }

    companion object {
        const val KEY_DETAIL = "key"
    }

}