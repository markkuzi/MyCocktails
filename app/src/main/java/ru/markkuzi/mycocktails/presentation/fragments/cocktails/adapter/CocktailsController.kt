package ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter

import android.view.ViewGroup
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.CocktailsItemBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class CocktailsController :
    BindableItemController<CocktailsListUi, CocktailsController.Holder>() {

    var onCocktailItemClickListener: ((cocktail: CocktailsListUi) -> Unit)? = null

    override fun getItemId(data: CocktailsListUi) = data.getId()

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<CocktailsListUi>(parent, R.layout.cocktails_item) {

        private val binding = CocktailsItemBinding.bind(itemView)

        override fun bind(data: CocktailsListUi) {
            with(binding) {
                val mapper = ListItemUi(tvCocktailName, ivCocktailImage)
                data.map(mapper)

                root.setOnClickListener {
                    onCocktailItemClickListener?.invoke(data)
                }
            }
        }
    }
}