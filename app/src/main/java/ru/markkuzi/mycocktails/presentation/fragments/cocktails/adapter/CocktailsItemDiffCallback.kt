package ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

class CocktailsItemDiffCallback : DiffUtil.ItemCallback<CocktailsListUi>() {
    override fun areItemsTheSame(oldItem: CocktailsListUi, newItem: CocktailsListUi): Boolean {
        return oldItem.map(newItem)
    }

    override fun areContentsTheSame(
        oldItem: CocktailsListUi,
        newItem: CocktailsListUi,
    ): Boolean {
        return oldItem == newItem
    }
}