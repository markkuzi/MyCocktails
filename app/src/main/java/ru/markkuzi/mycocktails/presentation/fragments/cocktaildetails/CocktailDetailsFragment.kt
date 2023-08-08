package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailDetailsBinding


class CocktailDetailsFragment : Fragment(R.layout.fragment_cocktail_details) {

    private val binding by viewBinding(FragmentCocktailDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}