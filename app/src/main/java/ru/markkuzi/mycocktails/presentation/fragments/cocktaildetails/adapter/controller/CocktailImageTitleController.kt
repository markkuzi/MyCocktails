package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller

import android.view.ViewGroup
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.CocktailDetailImageTitleBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.ImageTitleCocktailUi
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class CocktailImageTitleController :
    BindableItemController<ImageTitleCocktailUi, CocktailImageTitleController.Holder>() {

    override fun getItemId(data: ImageTitleCocktailUi) = data.hashCode()

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<ImageTitleCocktailUi>(parent, R.layout.cocktail_detail_image_title) {

        private val binding = CocktailDetailImageTitleBinding.bind(itemView)

        override fun bind(data: ImageTitleCocktailUi) {
            binding.titleTv.text = data.title
            binding.ivImage.setImageURI(data.image)
        }
    }
}