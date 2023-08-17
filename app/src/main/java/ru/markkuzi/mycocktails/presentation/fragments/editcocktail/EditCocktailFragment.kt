package ru.markkuzi.mycocktails.presentation.fragments.editcocktail

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentEditCocktailBinding


@AndroidEntryPoint
class EditCocktailFragment : Fragment(R.layout.fragment_edit_cocktail) {

    private val viewModel: EditCocktailViewModel by viewModels()
    private val binding by viewBinding(FragmentEditCocktailBinding::bind)
    private var cocktailId: Int = 1
    private var imageUri: Uri = Uri.EMPTY

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
            binding.ivCocktailImage.setImageURI(it.imageUri.toUri())
            imageUri = it.imageUri.toUri()
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etTitle.text.toString()
            val description = binding.etDescriptionLabel.text.toString()
            val recipe = binding.etRecipe.text.toString()
            viewModel.saveCocktail(cocktailId, name, description, recipe, imageUri)
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

    private fun parseArgs() {
        requireArguments().getInt(KEY_EDIT)?.let {
            cocktailId = it
        }
    }

    companion object {
        const val KEY_EDIT = "edit"
    }

}