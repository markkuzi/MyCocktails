package ru.markkuzi.mycocktails.presentation.fragments.editcocktail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentEditCocktailBinding


class EditCocktailFragment : Fragment(R.layout.fragment_edit_cocktail) {

    private val binding by viewBinding(FragmentEditCocktailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}