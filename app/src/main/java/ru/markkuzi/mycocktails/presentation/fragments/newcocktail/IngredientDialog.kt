package ru.markkuzi.mycocktails.presentation.fragments.newcocktail

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ru.markkuzi.mycocktails.R


interface Ingredient {

    fun getIngredient(): String

}

class IngredientDialog(context: Context) : Dialog(context), Ingredient {

    private var ingredient: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(layoutInflater.inflate(R.layout.add_ingrediets_dialog, null))
        this.window?.setBackgroundDrawableResource(R.drawable.ingredients_background)
        val editText: EditText = this.findViewById(R.id.etIngredient)
        val addToIngredient: Button = this.findViewById(R.id.btnAddIngredient)
        val closeDialog: Button = this.findViewById(R.id.btnCancelIngredient)

        addToIngredient.setOnClickListener {
            ingredient = editText.text.toString()
            this.dismiss()
        }

        closeDialog.setOnClickListener {
            this.dismiss()
        }

    }

    override fun getIngredient(): String {
        return ingredient
    }
}