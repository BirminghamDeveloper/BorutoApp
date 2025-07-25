package com.hashinology.borutoapp.di

import android.content.Context
import com.hashinology.borutoapp.data.manager.DataStoreOperationsImpl
import com.hashinology.borutoapp.data.repository.Repository
import com.hashinology.domain.manager.LocalManager
import com.hashinology.domain.use_cases.UseCases
import com.hashinology.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.hashinology.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.hashinology.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.hashinology.domain.use_cases.save_onboard.SaveOnBoardingUseCase
import com.hashinology.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    /*
    the Return type we providing (DataStoreOperations) in this module
    will be used by Dagger/Hilt to see which dependency we need
     */
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): LocalManager{
        return DataStoreOperationsImpl(context)
    }

    @Provides
    @Singleton
    // one function that passes the repo to all use cases we have
    fun provideUseCases(repo: Repository): UseCases{
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repo),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repo),
            getAllHeroesUseCase = GetAllHeroesUseCase(repo),
            searchHeroesUseCase = SearchHeroesUseCase(repo),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repo)
        )
    }
}