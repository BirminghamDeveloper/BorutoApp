package com.hashinology.domain.use_cases.read_onboarding

import com.hashinology.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repo: Repository
) {
    operator fun invoke(): Flow<Boolean>{
        return repo.readOnBoardingState()
    }
}