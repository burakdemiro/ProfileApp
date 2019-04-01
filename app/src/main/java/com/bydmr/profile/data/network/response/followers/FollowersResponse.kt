package com.bydmr.profile.data.network.response.followers

import com.google.gson.annotations.SerializedName

data class FollowersResponse(
    @SerializedName("Errors")
    val errors: List<Any>,
    @SerializedName("IsSuccess")
    val isSuccess: Boolean,
    @SerializedName("Result")
    val result: FollowersInfoContainer
)