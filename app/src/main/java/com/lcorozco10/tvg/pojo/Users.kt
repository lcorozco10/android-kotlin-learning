package com.lcorozco10.tvg.pojo

data class Users(
        val id: Int,
        val picture: String,
        val age: Int,
        val eyeColor: String,
        val names: Names,
        val company: String,
        val email: String,
        val phone: String,
        val registered: String,
        val favoriteFruit: String
)

data class Names(
        val first: String,
        val last: String
)

