package ru.markkuzi.mycocktails.presentation.fragments.newcocktail.adapter

import androidx.recyclerview.widget.DiffUtil

class IngredientItemDiffCallback : DiffUtil.ItemCallback<Ingredient>() {
    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem == newItem
    }
}