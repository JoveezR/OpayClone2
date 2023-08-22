package screens

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash")
    object LoginScreen: Screen("login")
    object Dashboard: Screen("dash")
    object Deposit: Screen("deposit")
    object Withdraw: Screen("withdraw")
}
