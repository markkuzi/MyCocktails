package ru.markkuzi.mycocktails.presentation.fragments.cocktails.adapter

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

class ListItemUi(
    private val tvName: TextView,
    private val ivImage: ImageView,
) : CocktailsListUi.Mapper<Unit> {
    override fun map(id: Int, name: String, imageUri: String) {
        tvName.text = name
        if (imageUri.toUri() == Uri.EMPTY)
            ivImage.setImageResource(R.drawable.cocktail_placeholder)
        else
            ivImage.setImageURI(imageUri.toUri())
    }
}