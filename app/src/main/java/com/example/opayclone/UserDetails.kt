package com.example.opayclone

data class UserDetails(
    val fullName: String,
    val mobileNumber:String,
    val nickName: String,
    val gender: String,
    val dateOfBirth: Int,
    val email: String,
    val address: String

)

data class UserAccount(
    val opayAccountNumber: Int,
    val accountTier: String,
    val bvn: Int
)