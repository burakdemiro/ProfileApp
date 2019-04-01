package com.bydmr.profile.data.repository

import androidx.lifecycle.LiveData
import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.data.network.response.member.MemberResponse
import com.bydmr.profile.data.network.response.movies.MoviesResponse

interface FakeRepository {
    suspend fun getMember(): LiveData<MemberResponse>
    suspend fun getFollowers(): LiveData<FollowersResponse>
    suspend fun getMovies(): LiveData<MoviesResponse>
}