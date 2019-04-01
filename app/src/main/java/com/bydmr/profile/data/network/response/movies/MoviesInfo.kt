package com.bydmr.profile.data.network.response.movies

import com.google.gson.annotations.SerializedName

data class MoviesInfo(
        @SerializedName("Id")
        val id: String,
        val createDate: String,
        val isLiked: Boolean,
        val likeCount: Int,
        val name: String,
        val profilePictureUrl: String
)