package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailsBinding

class CocktailsFragment : Fragment(R.layout.fragment_cocktails) {

    private val binding by viewBinding(FragmentCocktailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newCocktails.text = "cocktails list"

        binding.newCocktails.setOnClickListener {

            findNavController().navigate(
                R.id.action_cocktailsFragment_to_newCocktailFragment
            )
        }

        binding.details.setOnClickListener {
            findNavController().navigate(
                R.id.action_cocktailsFragment_to_cocktailDetailsFragment
            )
        }

    }

}