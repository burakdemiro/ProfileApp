package com.bydmr.profile.data.network

import androidx.lifecycle.LiveData
import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.data.network.response.member.MemberResponse
import com.bydmr.profile.data.network.response.movies.MoviesResponse

interface DataSource {
    val downloadedMember: LiveData<MemberResponse>
    val downloadedFollowers: LiveData<FollowersResponse>
    val downloadedMovies: LiveData<MoviesResponse>

    suspend fun fetchMember()
    suspend fun fetchFollowers()
    suspend fun fetchMovies()
}