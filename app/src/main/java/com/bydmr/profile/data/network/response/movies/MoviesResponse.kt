package com.bydmr.profile.data.network.response.movies

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
        @SerializedName("Errors")
        val errors: List<Any>,
        @SerializedName("IsSuccess")
        val isSuccess: Boolean,
        @SerializedName("Result")
        val result: MoviesInfoContainer
)