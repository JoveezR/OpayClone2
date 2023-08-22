package com.example.opayclone

import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavHostController

class AppViewModel(application: Application) : AndroidViewModel(application) {
        var context: Context? = null
        var showPassword = mutableStateOf(true)
        var showBalance = mutableStateOf(true)
        var showAccountNumber = mutableStateOf(true)
        var navController : NavHostController? = null
        var currentUser = User("","", "",0.0,"")

        val users = mutableListOf<User>(
            User("Josiah Idoko","jowizaza1", "lojoo1", 50000.0, 8039906379.toString()),
            User("Shaibu Dare","ladolin", "ladoo9", 4000.0, 8157272192.toString() ),
            User("Anna Idoko","annie4", "an4get", 20000.0, 8059114018.toString())
        )
        var showTopBar = mutableStateOf(true)


    fun addMoney(balance: Double){
        currentUser.walletBalance = currentUser.walletBalance + balance
    }
    fun withdraw(balance: Double) {
        currentUser.walletBalance = currentUser.walletBalance - balance
    }

}
