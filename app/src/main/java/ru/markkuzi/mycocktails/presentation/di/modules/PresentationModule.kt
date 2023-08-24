package ru.markkuzi.mycocktails.presentation.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.mycocktails.presentation.ManageResources
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.CocktailDetailsItemsCreator
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.CocktailDomainToDetailsUi
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.DescriptionUi
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.ImageTitleCocktailUi
import ru.markkuzi.mycocktails.presentation.fragments.cocktaildetails.adapter.RecipeUi
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailDomainToUi
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun providesDomainToUiMapper(): Cocktail.Mapper<CocktailsListUi> = CocktailDomainToUi()

    @Provides
    fun providesDomainToImageTitleMapper(): Cocktail.Mapper<ImageTitleCocktailUi> =
        CocktailDomainToDetailsUi.ImageTitle()

    @Provides
    fun providesDomainToDetailsDescriptionMapper(): DescriptionUi =
        CocktailDomainToDetailsUi.Description()

    @Provides
    fun providesDomainToListIngredientsMapper(): Cocktail.Mapper<List<String>> =
        CocktailDomainToDetailsUi.ListIngredients()

    @Provides
    fun providesDomainToDetailsRecipeMapper(
        manageResources: ManageResources,
    ): RecipeUi = CocktailDomainToDetailsUi.Recipe(manageResources)

    @Provides
    @Singleton
    fun providesManageResources(
        @ApplicationContext context: Context,
    ): ManageResources = ManageResources.Base(context)

    @Provides
    @Singleton
    fun providesCocktailDetailsItemsCreator(
        imageTitleMapper: Cocktail.Mapper<ImageTitleCocktailUi>,
        listDescriptionMapper: DescriptionUi,
        listIngredientsMapper: Cocktail.Mapper<List<String>>,
        listRecipeMapper: RecipeUi,
    ): CocktailDetailsItemsCreator = CocktailDetailsItemsCreator.Base(
        imageTitleMapper,
        listDescriptionMapper,
        listIngredientsMapper,
        listRecipeMapper,
    )

}