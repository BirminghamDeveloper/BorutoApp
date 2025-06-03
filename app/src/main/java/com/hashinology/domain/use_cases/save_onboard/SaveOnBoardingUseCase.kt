package com.hashinology.domain.use_cases.save_onboard

import com.hashinology.borutoapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repo: Repository
) {
    /*
     reason used the invoke() is when we call this class it will execute
     what inside {} block immediately without the need to call the functions
     */
    suspend operator fun invoke(completed: Boolean){
        repo.saveOnBoadingState(completed)
    }
}