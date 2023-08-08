package ru.markkuzi.mycocktails.presentation.fragments.newcocktail

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentEditCocktailBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsViewModel
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter.CocktailsListAdapter
import ru.markkuzi.mycocktails.presentation.fragments.newcocktail.adapter.IngredientsListAdapter

@AndroidEntryPoint
class NewCocktailFragment: Fragment(R.layout.fragment_edit_cocktail) {

    private val viewModel: NewCocktailViewModel by viewModels()
    private val binding by viewBinding(FragmentEditCocktailBinding::bind)
    private val ingredientsAdapter by lazy { IngredientsListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvIngredients.adapter = ingredientsAdapter


        binding.fabAddNewIngredient.setOnClickListener {
            showDishDialog()
        }

        viewModel.ingredients.observe(viewLifecycleOwner) {
            ingredientsAdapter.submitList(it)
            ingredientsAdapter.notifyDataSetChanged()
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etTitle.text.toString()
            val description = binding.etDescriptionLabel.text.toString()
            val recipe = binding.etRecipe.text.toString()
            viewModel.saveCocktail(name, description, recipe)
            findNavController().popBackStack()
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun showDishDialog() {
        val dialog = Dialog(requireContext())

        dialog.setContentView(layoutInflater.inflate(R.layout.add_ingrediets_dialog, null))
        dialog.window?.setBackgroundDrawableResource(R.drawable.ingredients_background)
        val editText: EditText = dialog.findViewById(R.id.etIngredient)
        val addToIngredient: Button = dialog.findViewById(R.id.btnAddIngredient)
        val closeDialog: Button = dialog.findViewById(R.id.btnCancelIngredient)
        dialog.show()


        addToIngredient.setOnClickListener {
            val text = editText.text.toString()
            viewModel.addIngredient(text)
            dialog.hide()
        }

        closeDialog.setOnClickListener {
            dialog.hide()
        }

    }

}