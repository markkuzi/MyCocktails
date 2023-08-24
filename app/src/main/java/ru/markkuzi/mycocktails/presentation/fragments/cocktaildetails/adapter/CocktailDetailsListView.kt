package ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import ru.markkuzi.mycocktails.databinding.CocktailDetailsCarouselViewBinding
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.controller.CocktailIngredientsController
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

class CocktailDetailsListView constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {

    private val detailsAdapter = EasyAdapter()

    private val binding = CocktailDetailsCarouselViewBinding.inflate(
        LayoutInflater.from(context), this
    )

    init {
        initRecycler()
    }

    fun setup(details: List<String>) {
        ItemList.create()
            .addAll(details, CocktailIngredientsController())
            .let { detailsAdapter.setItems(it) }
    }

    private fun initRecycler() {
        binding.detailsCarouselRv.adapter = detailsAdapter
        binding.detailsCarouselRv.layoutManager = LinearLayoutManager(context)
    }

}