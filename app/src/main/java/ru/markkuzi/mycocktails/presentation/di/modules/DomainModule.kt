package ru.markkuzi.mycocktails.presentation.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.usecases.CreateNewCocktailUseCase
import ru.markkuzi.domain.usecases.DeleteCocktailByIdUseCase
import ru.markkuzi.domain.usecases.EditCocktailUseCase
import ru.markkuzi.domain.usecases.GetCocktailDetailsUseCase
import ru.markkuzi.domain.usecases.GetCocktailsUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providesGetCocktailsUseCase(repository: CocktailsRepository): GetCocktailsUseCase {
        return GetCocktailsUseCase.Base(repository)
    }

    @Provides
    fun providesGetCocktailDetails(repository: CocktailsRepository): GetCocktailDetailsUseCase {
        return GetCocktailDetailsUseCase.Base(repository)
    }

    @Provides
    fun providesCreateNewCocktailUseCase(repository: CocktailsRepository): CreateNewCocktailUseCase {
        return CreateNewCocktailUseCase.Base(repository)
    }

    @Provides
    fun providesEditCocktailUseCase(repository: CocktailsRepository): EditCocktailUseCase {
        return EditCocktailUseCase.Base(repository)
    }

    @Provides
    fun providesDeleteCocktailByIdUseCase(repository: CocktailsRepository): DeleteCocktailByIdUseCase {
        return DeleteCocktailByIdUseCase.Base(repository)
    }

}