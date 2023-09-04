package ru.markkuzi.mycocktails.presentation.fragments.newcocktail

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.presentation.customviews.BottomButtonsView


interface Ingredient {

    fun getIngredient(): String

}

class IngredientDialog(context: Context) : Dialog(context), Ingredient {

    private var ingredient: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(layoutInflater.inflate(R.layout.add_ingrediets_dialog, null))
        this.window?.attributes?.windowAnimations = R.style.MyDialogAnimation
        this.window?.setBackgroundDrawableResource(R.drawable.ingredients_background)
        val editText: EditText = this.findViewById(R.id.etIngredient)
        val bottomButtons: BottomButtonsView = this.findViewById(R.id.bottomButtons)

        bottomButtons.setOnPositiveButtonClickListener {
            ingredient = editText.text.toString()
            this.dismiss()
        }

        bottomButtons.setOnNegativeButtonClickListener {
            this.dismiss()
        }

    }

    override fun getIngredient(): String {
        return ingredient
    }
}