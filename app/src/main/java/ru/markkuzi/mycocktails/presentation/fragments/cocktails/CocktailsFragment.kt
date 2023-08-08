package ru.markkuzi.mycocktails.presentation.fragments.cocktails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.FragmentCocktailsBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter.CocktailsListAdapter

@AndroidEntryPoint
class CocktailsFragment : Fragment(R.layout.fragment_cocktails) {

    private val viewModel: CocktailsViewModel by viewModels()
    private val binding by viewBinding(FragmentCocktailsBinding::bind)
    private val cocktailsAdapter by lazy { CocktailsListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCocktails.adapter = cocktailsAdapter
        binding.rvCocktails.layoutManager = GridLayoutManager(requireContext(),2)

        viewModel.getCocktails()

        viewModel.cocktails.observe(viewLifecycleOwner) {
            cocktailsAdapter.submitList(it)
        }

        binding.fabAddNewCocktail.setOnClickListener{
            viewModel.navigate(findNavController())
        }



    }

}