package com.hashinology.domain.use_cases

import com.hashinology.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.hashinology.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.hashinology.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.hashinology.domain.use_cases.save_onboard.SaveOnBoardingUseCase
import com.hashinology.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)
