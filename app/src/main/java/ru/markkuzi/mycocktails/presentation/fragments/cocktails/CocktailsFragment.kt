package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailsBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.CocktailDetailsFragment
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter.CocktailsController
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

@AndroidEntryPoint
class CocktailsFragment : Fragment(R.layout.fragment_cocktails) {

    private val viewModel: CocktailsViewModel by viewModels()
    private val binding by viewBinding(FragmentCocktailsBinding::bind)

    private val easyAdapter = EasyAdapter()
    private val cocktailsController = CocktailsController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCocktails.adapter = easyAdapter
        binding.rvCocktails.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.getCocktails()

        viewModel.cocktails.observe(viewLifecycleOwner) { list ->
            ItemList.create()
                .addAll(list, cocktailsController)
                .let { easyAdapter.setItems(it) }
        }

        binding.fabAddNewCocktail.setOnClickListener {
            viewModel.navigate(findNavController())
        }

        cocktailsController.onCocktailItemClickListener = {
            val args = Bundle().apply {
                putInt(CocktailDetailsFragment.KEY_DETAIL, it.getId())
            }
            findNavController().navigate(
                R.id.action_cocktailsFragment_to_cocktailDetailsFragment,
                args
            )
        }
    }
}