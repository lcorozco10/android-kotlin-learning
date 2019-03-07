package com.lcorozco10.tvg.pojo

import com.google.gson.annotations.SerializedName

data class Users(
        @SerializedName("id")val id: String,
        @SerializedName("picture") val picture: String,
        @SerializedName("age") val age: Int,
        @SerializedName("eyeColor") val eyeColor: String,
        @SerializedName("name") val names: Names,
        @SerializedName("company") val company: String,
        @SerializedName("email") val email: String,
        @SerializedName("phone") val phone: String,
        @SerializedName("registered") val registered: String,
        @SerializedName("favoriteFruit") val favoriteFruit: String
)

data class Names(
        @SerializedName("first") val first: String,
        @SerializedName("last")val last: String
)

