package ru.markkuzi.mycocktails.presentation.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.markkuzi.data.CocktailDbModelToDomain
import ru.markkuzi.data.CocktailDomainToData
import ru.markkuzi.data.CocktailsRepositoryImpl
import ru.markkuzi.data.localDB.CocktailDao
import ru.markkuzi.data.localDB.CocktailDbModel
import ru.markkuzi.data.localDB.CocktailsDB
import ru.markkuzi.domain.CocktailsRepository
import ru.markkuzi.domain.entities.Cocktail
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesRoomRepository(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        CocktailsDB::class.java,
        "cocktails_db"
    ).build()

    @Singleton
    @Provides
    fun providesCocktailDao(db: CocktailsDB) = db.cocktailDao

    @Provides
    fun providesDbToDomainMapper(): CocktailDbModel.Mapper<Cocktail> = CocktailDbModelToDomain()

    @Provides
    fun providesDomainToDataMapper(): Cocktail.Mapper<CocktailDbModel> = CocktailDomainToData()

    @Provides
    fun providesCocktailRepository(
        cocktailDao: CocktailDao,
        mapperToDomain: CocktailDbModel.Mapper<Cocktail>,
        mapperToData: Cocktail.Mapper<CocktailDbModel>,
    ): CocktailsRepository = CocktailsRepositoryImpl(cocktailDao, mapperToDomain, mapperToData)

}