package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller

import android.view.ViewGroup
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.CocktailDetailsListViewBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class CocktailIngredientsCarouselController :
    BindableItemController<List<String>, CocktailIngredientsCarouselController.Holder>() {

    override fun getItemId(data: List<String>) = "COCKTAIL_CAROUSEL_CONTROLLER"

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<List<String>>(
            parent,
            R.layout.cocktail_details_list_view
        ) {

        private val binding = CocktailDetailsListViewBinding.bind(itemView)

        override fun bind(data: List<String>) {
            binding.cocktailDetailsCarousel.setup(data)
        }
    }
}