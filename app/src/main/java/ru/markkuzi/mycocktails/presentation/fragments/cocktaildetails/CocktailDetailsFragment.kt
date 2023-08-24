package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailDetailsBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.CocktailDetailsUiItem
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller.CocktailDetailsController
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller.CocktailImageTitleController
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller.CocktailIngredientsCarouselController
import ru.markkuzi.mycocktails.presentation.fragments.editcocktail.EditCocktailFragment
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.android.easyadapter.item.BindableItem


@AndroidEntryPoint
class CocktailDetailsFragment : Fragment(R.layout.fragment_cocktail_details) {

    private val viewModel: CocktailDetailsViewModel by viewModels()
    private val binding by viewBinding(FragmentCocktailDetailsBinding::bind)
    private var cocktailId: Int = 1

    private val cocktailImageTitleController = CocktailImageTitleController()
    private val cocktailDetailsController = CocktailDetailsController()
    private val cocktailIngredientsCarouselController = CocktailIngredientsCarouselController()

    private val easyAdapter = EasyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCocktailDetails(cocktailId)

        with(binding.detailsRv) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = easyAdapter
        }

        viewModel.cocktailDetails.observe(viewLifecycleOwner) {
            val uiItems = it.map { uiItem ->
                when (uiItem) {
                    is CocktailDetailsUiItem.UiCocktailDetailsImageTitleItem -> BindableItem(
                        uiItem.imageTitle,
                        cocktailImageTitleController,
                    )

                    is CocktailDetailsUiItem.UiCocktailDescriptionItem -> BindableItem(
                        uiItem.description,
                        cocktailDetailsController,
                    )

                    is CocktailDetailsUiItem.UiCocktailIngredientsListItem -> BindableItem(
                        uiItem.ingredients,
                        cocktailIngredientsCarouselController,
                    )

                    is CocktailDetailsUiItem.UiCocktailRecipeItem -> BindableItem(
                        uiItem.recipe,
                        cocktailDetailsController,
                    )
                }
            }
            easyAdapter.setItems(ItemList(uiItems))
        }

        binding.btnDelete.setOnClickListener {
            viewModel.deleteCocktail(cocktailId)
            findNavController().popBackStack()
        }

        binding.btnEdit.setOnClickListener {
            val args = Bundle().apply {
                putInt(EditCocktailFragment.KEY_EDIT, cocktailId)
            }
            findNavController().navigate(
                R.id.action_cocktailDetailsFragment_to_editCocktailFragment,
                args
            )
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