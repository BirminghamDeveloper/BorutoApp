package com.hashinology.domain.use_cases.get_selected_hero

import com.hashinology.borutoapp.data.repository.Repository
import com.hashinology.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repo: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repo.getSelectedHero(heroId = heroId)
    }
}