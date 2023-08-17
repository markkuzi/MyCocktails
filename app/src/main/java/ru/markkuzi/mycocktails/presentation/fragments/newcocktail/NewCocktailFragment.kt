package ru.markkuzi.mycocktails.presentation.fragments.newcocktail

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentEditCocktailBinding
import ru.markkuzi.mycocktails.presentation.fragments.newcocktail.adapter.IngredientsListAdapter

@AndroidEntryPoint
class NewCocktailFragment : Fragment(R.layout.fragment_edit_cocktail) {

    private val viewModel: NewCocktailViewModel by viewModels()
    private val binding by viewBinding(FragmentEditCocktailBinding::bind)
    private val ingredientsAdapter by lazy { IngredientsListAdapter() }
    private var imageUri = Uri.EMPTY
    private val ingredientDialog by lazy { IngredientDialog(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvIngredients.adapter = ingredientsAdapter


        binding.fabAddNewIngredient.setOnClickListener {

            ingredientDialog.show()
            ingredientDialog.setOnDismissListener {
                viewModel.addIngredient(ingredientDialog.getIngredient())
            }
        }

        viewModel.ingredients.observe(viewLifecycleOwner) {
            ingredientsAdapter.submitList(it)
            ingredientsAdapter.notifyDataSetChanged()
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etTitle.text.toString()
            val description = binding.etDescriptionLabel.text.toString()
            val recipe = binding.etRecipe.text.toString()
            viewModel.saveCocktail(name, description, recipe, imageUri)
            findNavController().popBackStack()
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.ivCocktailImage.setOnClickListener {
            ImagePicker.with(requireActivity())
                .cropSquare()
                .createIntent {
                    startForCocktailImageResult.launch(it)
                }
        }
    }

    private val startForCocktailImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                val fileUri = data?.data ?: Uri.EMPTY
                imageUri = fileUri
                binding.ivCocktailImage.setImageURI(fileUri)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                imageUri = Uri.EMPTY
            } else {
                imageUri = Uri.EMPTY
            }
        }

}