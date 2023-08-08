package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailsBinding

class CocktailsFragment : Fragment(R.layout.fragment_cocktails) {

    private val binding by viewBinding(FragmentCocktailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text.text = "cocktails list"

    }

}