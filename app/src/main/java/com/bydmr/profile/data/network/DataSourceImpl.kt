package com.bydmr.profile.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.data.network.response.member.MemberResponse
import com.bydmr.profile.data.network.response.movies.MoviesResponse

class DataSourceImpl(
        private val profileApiService: ProfileApiService
) : DataSource {

    // Encapsulation
    private val _downloadedMember = MutableLiveData<MemberResponse>()
    override val downloadedMember: LiveData<MemberResponse>
        get() = _downloadedMember

    override suspend fun fetchMember() {
        val fetchedMember = profileApiService.getMember().await()
        _downloadedMember.postValue(fetchedMember)
    }

    private val _downloadedFollowers = MutableLiveData<FollowersResponse>()
    override val downloadedFollowers: LiveData<FollowersResponse>
        get() = _downloadedFollowers

    override suspend fun fetchFollowers() {
        val fetchedFollowers = profileApiService.getFollowers().await()
        _downloadedFollowers.postValue(fetchedFollowers)
    }

    private val _downloadedMovies = MutableLiveData<MoviesResponse>()
    override val downloadedMovies: LiveData<MoviesResponse>
        get() = _downloadedMovies

    override suspend fun fetchMovies() {
        val fetchedMovies = profileApiService.getMovies().await()
        _downloadedMovies.postValue(fetchedMovies)
    }
}