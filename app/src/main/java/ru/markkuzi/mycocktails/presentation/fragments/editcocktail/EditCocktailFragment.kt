package ru.markkuzi.mycocktails.presentation.fragments.editcocktail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentEditCocktailBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.CocktailDetailsFragment
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.CocktailDetailsViewModel


@AndroidEntryPoint
class EditCocktailFragment : Fragment(R.layout.fragment_edit_cocktail) {

    private val viewModel: EditCocktailViewModel by viewModels()
    private val binding by viewBinding(FragmentEditCocktailBinding::bind)
    private var cocktailId : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCocktail(cocktailId)
        binding.fabAddNewIngredient.visibility = View.GONE

        viewModel.cocktail.observe(viewLifecycleOwner) {
            binding.etTitle.setText(it.name)
            binding.etDescriptionLabel.setText(it.description)
            binding.etRecipe.setText(it.recipe)
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etTitle.text.toString()
            val description = binding.etDescriptionLabel.text.toString()
            val recipe = binding.etRecipe.text.toString()
            viewModel.saveCocktail(cocktailId, name, description, recipe)
            findNavController().popBackStack()
        }


    }

    private fun parseArgs() {
        requireArguments().getInt(KEY_EDIT)?.let {
            cocktailId = it
        }
    }

    companion object {
        const val KEY_EDIT = "edit"
    }

}