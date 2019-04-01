package com.bydmr.profile.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bydmr.profile.data.repository.FakeRepository

class ProfileFragmentViewModelFactory(
        private val fakeRepository: FakeRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(fakeRepository) as T
    }
}