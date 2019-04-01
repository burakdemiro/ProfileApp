package com.bydmr.profile.data.network.response.followers

import com.google.gson.annotations.SerializedName

data class FollowersInfoContainer(
    @SerializedName("ItemCount")
    val itemCount: Int,
    @SerializedName("Items")
    val items: List<FollowersInfo>
)