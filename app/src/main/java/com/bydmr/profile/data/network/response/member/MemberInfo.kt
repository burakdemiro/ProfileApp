package com.bydmr.profile.data.network.response.member

data class MemberInfo(
    val profileBackgroundPictureUrl: String,
    val profilePictureUrl: String,
    val userId: Int,
    val username: String
)