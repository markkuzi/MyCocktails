package ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.markkuzi.mycocktails.databinding.CocktailsItemBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

class CocktailsListAdapter :
    ListAdapter<CocktailsListUi, CocktailsListAdapter.CocktailsViewHolder>(CocktailsItemDiffCallback()) {

    inner class CocktailsViewHolder(
        val binding: CocktailsItemBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsViewHolder {
        val binding = CocktailsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CocktailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CocktailsViewHolder, position: Int) {
        val cocktail = getItem(position)

        with(holder.binding) {
            val mapper = ListItemUi(tvCocktailName, ivCocktailImage)
            cocktail.map(mapper)
        }
    }
}