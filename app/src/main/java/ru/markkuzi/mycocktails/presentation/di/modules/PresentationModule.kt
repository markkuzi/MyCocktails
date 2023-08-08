package ru.markkuzi.mycocktails.presentation.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.markkuzi.domain.entities.Cocktail
import ru.markkuzi.mycocktails.presentation.CocktailDomainToUi
import ru.markkuzi.mycocktails.presentation.fragments.cocktails.CocktailsListUi

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun providesDomainToUiMapper(): Cocktail.Mapper<CocktailsListUi> = CocktailDomainToUi()

}