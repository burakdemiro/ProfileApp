package com.bydmr.profile.data.network.response.member

import com.google.gson.annotations.SerializedName

data class MemberResponse(
    @SerializedName("Errors")
    val errors: List<Any>,
    @SerializedName("IsSuccess")
    val isSuccess: Boolean,
    @SerializedName("Result")
    val result: MemberInfo
)