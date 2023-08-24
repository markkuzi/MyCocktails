package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller

import android.view.ViewGroup
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.CocktailsIngredientsItemViewBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder


class CocktailIngredientsController :
    BindableItemController<String, CocktailIngredientsController.Holder>() {

    override fun getItemId(data: String) = data.hashCode()

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<String>(parent, R.layout.cocktails_ingredients_item_view) {

        private val binding = CocktailsIngredientsItemViewBinding.bind(itemView)

        override fun bind(data: String) {
            if (data.isNotEmpty())
                binding.tvIngredient.text = data
        }
    }
}