package com.bydmr.profile.data.network.response.movies

import com.google.gson.annotations.SerializedName

data class MoviesInfoContainer(
        @SerializedName("ItemCount")
        val itemCount: Int,
        @SerializedName("Items")
        val items: List<MoviesInfo>
)