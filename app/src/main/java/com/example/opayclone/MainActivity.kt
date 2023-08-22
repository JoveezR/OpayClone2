package com.example.opayclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.opayclone.ui.theme.OpayCloneTheme
import kotlinx.coroutines.launch
import screens.Dashboard
import screens.Deposit
import screens.LoginScreen
import screens.Screen
import screens.SplashScreen
import screens.Withdraw

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AppViewModel(this.application)
        val vertical = 10.dp
        val horizontal = 10.dp
        setContent {
            OpayCloneTheme {
                // A surface container using the 'background' color from the theme
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val navController = rememberNavController()
                ModalNavigationDrawer(

                    drawerState = drawerState,
                    drawerContent = {

                        if (currentRoute(navController = navController) != Screen.SplashScreen.route)
                            if (currentRoute(navController = navController) != Screen.LoginScreen.route)
                                //if (currentRoute(navController = navController) != Screen.Dashboard.route)
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(373.dp)
                                        .background(Color(0xFFf5f5f5)),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 20.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.usericon),
                                                contentDescription = "user icon",
                                                modifier = Modifier
                                                    .padding(top = 20.dp)
                                                    .size(60.dp)
                                                    .clip(CircleShape)
                                                    .border(1.2.dp, Color.White, CircleShape)
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))

                                            Text(text = "JOZY")
                                        }

                                        Spacer(modifier = Modifier.height(24.dp))
                                        Column(
                                            modifier = Modifier
                                                .padding(6.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Card(
                                                modifier = Modifier
                                                    .padding(6.dp)
                                                    .height(325.dp)
                                                    .align(Alignment.CenterHorizontally)
                                                    .width(369.dp),
                                                colors = CardDefaults.cardColors(Color.White),


                                            ) {
                                                Row(
                                                    modifier = Modifier
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Full Name")
                                                    Text(text = "JOSIAH OCHE IDOKO")
                                                }
                                                //Divider(modifier = Modifier.height(1.2.dp), color = Color.Black)

                                                Row(
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .fillMaxWidth()
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Mobile Number")
                                                    Text(text = "+2348039906379")
                                                }
                                                //Divider(modifier = Modifier.height(1.2.dp), color = Color.Black)

                                                Row(
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .fillMaxWidth()
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Nick Name")
                                                    Text(text = "JOZY")
                                                }
                                                //Divider(modifier = Modifier.height(1.2.dp), color = Color.Black)

                                                Row(
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .fillMaxWidth()
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Gender")
                                                    Text(text = "Male")
                                                }
                                                //Divider(modifier = Modifier.height(1.2.dp), color = Color.Black)

                                                Row(
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .fillMaxWidth()
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Date Of Birth")
                                                    Text(text = "c400")
                                                }
                                                //Divider(modifier = Modifier.height(1.2.dp), color = Color.Black)

                                                Row(
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .fillMaxWidth()
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Email")
                                                    Text(text = "jochezy@gmail.com")
                                                }
                                                //Divider(modifier = Modifier.height(1.2.dp), color = Color.Black)

                                                Row(
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .fillMaxWidth()
                                                        .padding(horizontal = horizontal)
                                                        .padding(vertical = vertical)
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(text = "Address")
                                                    Text(text = "suite 151 3B")
                                                }
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(6.dp)
                                                .height(125.dp)
                                                .width(369.dp),
                                            colors = CardDefaults.cardColors(Color.White)
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .padding(start = 4.dp)
                                                    .fillMaxWidth()
                                                    .padding(horizontal = horizontal)
                                                    .padding(vertical = vertical)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(text = "OPay Account Number")
                                                Text(text = "8039906379")
                                            }
                                            Divider(modifier = Modifier.height(1.dp), color = Color.Black)

                                            Row(
                                                modifier = Modifier
                                                    .padding(start = 4.dp)
                                                    .fillMaxWidth()
                                                    .padding(horizontal = horizontal)
                                                    .padding(vertical = vertical)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(text = "Account Tier")
                                                Text(text = "Tier 2")
                                            }
                                            Divider(modifier = Modifier.height(1.dp), color = Color.Black)

                                            Row(
                                                modifier = Modifier
                                                    .padding(start = 4.dp)
                                                    .fillMaxWidth()
                                                    .padding(horizontal = horizontal)
                                                    .padding(vertical = vertical)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(text = "BVN")
                                                Text(text = "1282")
                                            }


                                        }
                                        Spacer(modifier = Modifier.height(22.dp))
                                        Button(onClick = {  },
                                            modifier = Modifier
                                                .padding(9.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF1DCF9F))
                                        ) {
                                            Text(
                                                text = "Upgrade to Merchant",
                                                modifier = Modifier
                                                    .padding(3.dp)
                                                    .height(30.dp)
                                                    .width(335.dp),
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 18.sp,
                                                color = Color.White,
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                    }

                                }
                    },
                    content = {

                        val scope = rememberCoroutineScope()

                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            topBar = {
                                navController.popBackStack()
                                if (currentRoute(navController = navController) != Screen.SplashScreen.route)
                                    if (currentRoute(navController = navController) != Screen.LoginScreen.route) {
                                       Row(
                                           modifier = Modifier.padding(6.dp),
                                           horizontalArrangement = Arrangement.spacedBy(5.dp)
                                       ) {
                                           TopAppBar(
                                               title = { Text(text = "Hi, JOZY") },
                                               modifier = Modifier
                                                   .padding(3.dp),
                                               navigationIcon = {
                                                   Image(
                                                       painter = painterResource(id = R.drawable.welcomicon),
                                                       contentDescription = "welcome icon",
                                                       modifier = Modifier
                                                           .padding(4.dp)
                                                           .size(84.dp)
                                                           .clip(CircleShape)
                                                           .clickable(
                                                               onClick = {
                                                                   if (drawerState.isOpen) {
                                                                       scope.launch {
                                                                           drawerState.close()
                                                                       }

                                                                   } else {
                                                                       scope.launch {
                                                                           drawerState.open()
                                                                       }
                                                                   }
                                                               }
                                                           )
                                                           .padding(16.dp)
                                                   )
                                               }
                                           )
                                       }
                                    }
                            },
                            floatingActionButton = {
                                if (currentRoute(navController = navController) != Screen.SplashScreen.route)
                                    if (currentRoute(navController = navController) != Screen.LoginScreen.route)
                                    if (currentRoute(navController = navController) != Screen.Dashboard.route)
                                    {
                                        FloatingActionButton(
                                            onClick = {
                                                // Handle the FAB click action here
                                            }
                                        ) {

                                        }
                                    }
                            },


                            content = {

                                Navigation(navController, viewModel)

                            },

                            bottomBar = {
                                if (currentRoute(navController = navController) != Screen.SplashScreen.route)
                                    if (currentRoute(navController = navController) != Screen.LoginScreen.route) {
//                                    {
//                                        val list = mutableListOf<BottomBarItem>()
//
//                                        var item1 = BottomBarItem(
//                                            icon = Icons.Outlined.Home,
//                                            title = "Outlook",
//                                            onItemClicked = { navController.navigate(Screen.MainScreen.route) },
//                                            Screen.MainScreen.route
//                                        )
//                                        list.add(item1)
//                                        var item2 = BottomBarItem(
//                                            icon = Icons.Filled.MailOutline,
//                                            title = "Chat",
//                                            onItemClicked = { navController.navigate(Screen.FirstScreen.route) },
//                                            Screen.FirstScreen.route
//                                        )
//                                        list.add(item2)
//                                        var item3 = BottomBarItem(
//                                            icon = Icons.Outlined.Settings,
//                                            title = "Settings",
//                                            onItemClicked = { navController.navigate(Screen.LastScreen.route) },
//                                            Screen.LastScreen.route
//                                        )
//                                        list.add(item3)
//                                        MenuAtTheDown(
//                                            items = list,
//                                            selectedIndex = 0,
//                                            navController = navController
//                                        )
                                    }
                            }

                        )
                    }
                )
            }
        }
    }

    @Composable
    fun RememberScaffoldState() {
        val scaffoldState = remember{ mutableStateOf("") }

//        Scaffold(
//            scaffoldState = scaffoldState,
//            content = {
//
//            }
//        ) {
//
//        }
//    }
    }


//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    topBar = {
//
//                    },
//                    content = { paddingValues ->
//                        Surface(modifier = Modifier.padding(paddingValues)) {
//                            Navigation(navController, viewModel)
//                        }
//                    }
//                )
//            }
//        }
//    }
//}
//
    
//    @Composable
//    fun withdrawTopBar(navController: NavHostController, drawerState: DrawerState) {
//           // navController.popBackStack()
//             val scope = CoroutineScope(Dispatchers.IO)
//         //   if (currentRoute(navController = navController) = Screen.Withdraw.route) {
//                    Row(
//                        modifier = Modifier.padding(6.dp),
//                        horizontalArrangement = Arrangement.spacedBy(5.dp)
//                    ) {
//                        TopAppBar(
//                            title = { Text(text = "Hi, JOZY") },
//                            modifier = Modifier
//                                .padding(3.dp),
//                            navigationIcon = {
//                                Image(
//                                    painter = painterResource(id = R.drawable.welcomicon),
//                                    contentDescription = "welcome icon",
//                                    modifier = Modifier
//                                        .padding(4.dp)
//                                        .size(84.dp)
//                                        .clip(CircleShape)
//                                        .clickable(
//                                            onClick = {
//                                                if (drawerState.isOpen) {
//                                                    scope.launch {
//                                                        drawerState.close()
//                                                    }
//
//                                                } else {
//                                                    scope.launch {
//                                                        drawerState.open()
//                                                    }
//                                                }
//                                            }
//                                        )
//                                        .padding(16.dp)
//                                )
//                            }
//                        )
//                    }
//                }



    @SuppressLint("ComposableDestinationInComposeScope")
    @Composable
    fun Navigation(navController: NavHostController, viewModel: AppViewModel) {
        NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
            composable(route = Screen.SplashScreen.route) {
                SplashScreen(
                    navigateToLoginScreen = {
                        navController.navigate(Screen.LoginScreen.route) {
                            popUpTo(Screen.SplashScreen.route) { inclusive = true }
                        }
                    })
            }
            composable(route = Screen.LoginScreen.route) {
                LoginScreen(navController, viewModel)
            }
            composable(route = Screen.Dashboard.route) {
                Dashboard(navController, viewModel)
            }
            composable(route = Screen.Deposit.route) {
                Deposit(navController, viewModel)
            }
            composable(route = Screen.Withdraw.route) {
                Withdraw(navController, viewModel)
            }
        }
    }

    @Composable
    fun Background(modifier: Modifier = Modifier) {


    }

    @Composable
    fun currentRoute(navController: NavHostController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.destination?.route
    }
}



//        //@Preview(showBackground = true)
//        @Composable
//        fun GreetingPreview() {
//            OpayCloneTheme {
//                Background()
//            }
//        }
//