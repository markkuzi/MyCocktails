package ru.markkuzi.mycocktails.presentation.fragments.newcocktail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.markkuzi.mycocktails.databinding.IngredientsItemBinding

class IngredientsListAdapter :
    ListAdapter<Ingredient, IngredientsListAdapter.IngredientsViewHolder>(IngredientItemDiffCallback()) {

    inner class IngredientsViewHolder(
        val binding: IngredientsItemBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val binding = IngredientsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val ingredients = getItem(position)

        holder.binding.tvCocktailName.text = ingredients.name

    }
}