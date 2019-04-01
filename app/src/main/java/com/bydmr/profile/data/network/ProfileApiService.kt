package com.bydmr.profile.data.network

import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.data.network.response.member.MemberResponse
import com.bydmr.profile.data.network.response.movies.MoviesResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// http://54.214.52.108:50895/api/values/member
// http://54.214.52.108:50895/api/values/Followers
// http://54.214.52.108:50895/api/values/movies

interface ProfileApiService {

    @GET("api/values/member")
    fun getMember(): Deferred<MemberResponse>

    @GET("api/values/Followers")
    fun getFollowers(): Deferred<FollowersResponse>

    @GET("api/values/movies")
    fun getMovies(): Deferred<MoviesResponse>

    companion object {
        operator fun invoke(): ProfileApiService {

            val requestInterceptor = Interceptor {

                var request = it.request()
                        .newBuilder()
                        .build()
                return@Interceptor it.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://54.214.52.108:50895/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProfileApiService::class.java)
        }
    }
}