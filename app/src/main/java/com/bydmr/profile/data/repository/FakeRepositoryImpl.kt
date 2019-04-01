package com.bydmr.profile.data.repository

import androidx.lifecycle.LiveData
import com.bydmr.profile.data.network.DataSource
import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.data.network.response.member.MemberResponse
import com.bydmr.profile.data.network.response.movies.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FakeRepositoryImpl(
        val dataSource: DataSource
) : FakeRepository {

    init {
       dataSource.apply {
           GlobalScope.launch(Dispatchers.IO) {
               fetchMember()
               fetchFollowers()
               fetchMovies()
           }
       }
    }

    override suspend fun getMember(): LiveData<MemberResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext dataSource.downloadedMember
        }
    }

    override suspend fun getFollowers(): LiveData<FollowersResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext dataSource.downloadedFollowers
        }
    }

    override suspend fun getMovies(): LiveData<MoviesResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext dataSource.downloadedMovies
        }
    }
}