package com.example.opayclone

data class User(
    val name: String,
    val username: String,
    val password: String,
    var walletBalance: Double,
    var accountNumber: String
)
