package com.bydmr.profile

import android.app.Application
import com.bydmr.profile.data.network.DataSource
import com.bydmr.profile.data.network.DataSourceImpl
import com.bydmr.profile.data.network.ProfileApiService
import com.bydmr.profile.data.repository.FakeRepository
import com.bydmr.profile.data.repository.FakeRepositoryImpl
import com.bydmr.profile.ui.profile.ProfileFragmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ProfileApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind() from singleton { ProfileApiService() }
        bind<DataSource>() with singleton { DataSourceImpl(instance()) }
        bind<FakeRepository>() with singleton { FakeRepositoryImpl(instance()) }
        bind() from provider { ProfileFragmentViewModelFactory(instance()) }
    }
}