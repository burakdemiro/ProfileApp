package com.bydmr.profile.ui.profile

import androidx.lifecycle.ViewModel;
import com.bydmr.profile.data.repository.FakeRepository
import com.bydmr.profile.util.lazyDeferred

class ProfileViewModel(
    fakeRepository: FakeRepository
) : ViewModel() {

    val member by lazyDeferred {
        fakeRepository.getMember()
    }

    val followers by lazyDeferred {
        fakeRepository.getFollowers()
    }

    val movies by lazyDeferred {
        fakeRepository.getMovies()
    }
}
