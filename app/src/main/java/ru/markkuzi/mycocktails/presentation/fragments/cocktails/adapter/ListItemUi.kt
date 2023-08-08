package ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter

import android.widget.ImageView
import android.widget.TextView
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

class ListItemUi(
    private val tvName: TextView,
    private val ivImage: ImageView,
) : CocktailsListUi.Mapper<Unit> {
    override fun map(id: Int, name: String, image: Int) {
        tvName.text = name
        val actualImage = if (image == 0)
            R.drawable.cocktail_placeholder
        else
            image
        ivImage.setImageResource(actualImage)
    }
}