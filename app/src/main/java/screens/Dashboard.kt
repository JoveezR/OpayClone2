package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.opayclone.AppViewModel
import com.example.opayclone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavController, viewModel: AppViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(9.dp)
        .background(Color(0xFFf5f5f5)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Card(
                modifier = Modifier
                    .width(385.dp)
                    .height(290.dp)
                    .padding(top = 64.dp),
                colors = CardDefaults.cardColors(Color(0xFF1DCF9F))
            ) {
              Column(
                  modifier = Modifier
                      .fillMaxSize(),
                  verticalArrangement = Arrangement.SpaceBetween
              ) {

                  Row(
                      modifier = Modifier
                          .fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                      Column(
                          modifier = Modifier
                              .padding(4.dp)
                              .height(128.dp)
                              .width(198.dp)
                              .background(Color.Transparent),
                          verticalArrangement = Arrangement.Top,
                          horizontalAlignment = Alignment.Start
                      ) {
                          Row(
                              modifier = Modifier.padding(9.dp),
                              verticalAlignment = Alignment.CenterVertically
                          ) {
                              Text(
                                  text = "Available Balance",
                                  modifier = Modifier
                                      .padding(8.dp),
                                  color = Color.White,
                                  fontSize = 13.sp,
                                  fontWeight = FontWeight.Bold
                              )
                              Box(
                                  modifier = Modifier
                                      .padding(4.dp)
                                      .height(24.dp)
                                      .width(22.dp)
                                      .background(Color.Transparent),
                                  contentAlignment = Alignment.Center
                              ) {

                                      Image(
                                          painter = painterResource(id = if(viewModel.showBalance.value) R.drawable.eye else R.drawable.hide),
                                          contentDescription = "view balance icon",
                                          contentScale = ContentScale.Inside,
                                          colorFilter = ColorFilter.tint(Color.White),
                                          modifier = Modifier.clickable(onClick = {
                                              viewModel.showBalance.value = !viewModel.showBalance.value
                                          })
                                      )


                              }
                          }
                          //Spacer(modifier = Modifier.height(4.dp))
                          Column(
                              modifier = Modifier
                                  .padding(3.dp)
                                  .height(188.dp)
                                  .width(117.dp)
                                  .background(Color.Transparent),
                              verticalArrangement = Arrangement.Top
                          ) {
                              Text(
                                  text = if(viewModel.showBalance.value) "#${viewModel.currentUser.walletBalance}" else "*".repeat(viewModel.currentUser.walletBalance.toString().length),
                                  modifier = Modifier
                                      .padding(6.dp),
                                  fontSize = 24.sp,
                                  color = Color.White
                              )
//                              Spacer(modifier = Modifier.height(4.dp))
                              Text(
                                  text = "& Cashback ****",
                                  modifier = Modifier
                                      .padding(4.dp),
                                  fontSize = 14.sp,
                                  fontWeight = FontWeight.SemiBold,
                                  color = Color.White
                              )
                          }
                      }

                      Row(modifier = Modifier.padding(9.dp),
                          verticalAlignment = Alignment.CenterVertically
                      ) {
                          Text(
                              text = "Transaction History",
                              modifier = Modifier
                                  .padding(8.dp),
                              color = Color.White,
                              fontSize = 13.sp,
                              fontWeight = FontWeight.Bold
                          )
                          Box(
                              modifier = Modifier
                                  .padding(4.dp)
                                  .height(24.dp)
                                  .width(22.dp)
                                  .background(Color.Transparent),
                              contentAlignment = Alignment.Center
                          ) {
                              Image(
                                  painter = painterResource(id = R.drawable.history),
                                  contentDescription = "history icon",
                                  contentScale = ContentScale.Inside,
                                  //colorFilter = ColorFilter.tint(Color.White),
                                  modifier = Modifier
                              )
                          }
                      }
                  }
                  
                  //Spacer(modifier = Modifier.height(25.dp))

                  Column(
                      modifier = Modifier
                          .fillMaxWidth()
                          .background(Color.Transparent),
                      horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                      Row(
                          modifier = Modifier
                              .padding(2.dp)
                              .width(361.dp).height(100.dp).background(Color.Transparent),
                          horizontalArrangement = Arrangement.spacedBy(32.dp),
                          verticalAlignment = Alignment.CenterVertically
                      ) {

                          val goToDeposit:()-> Unit = {
                              navController.navigate(Screen.Deposit.route)
                          }
                          val goToWithdraw:()-> Unit = {
                              navController.navigate(Screen.Withdraw.route)
                          }
                          MainMenu("Add Money", R.drawable.add, goToDeposit)
                          MainMenu(text = "Transfer", icon = R.drawable.transfer)
                          MainMenu("Withdraw", icon = R.drawable.withdraw, goToWithdraw)
                      }

                }

              }

            }
            Card(
                modifier = Modifier
                    .width(390.dp)
                    .height(290.dp)
                    .padding(top = 24.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MenuOne(text = "Airtime", icon = R.drawable.airtime)
                        MenuOne(text = "Data", icon = R.drawable.data)
                        MenuOne(text = "Betting", icon = R.drawable.betting)
                        MenuOne(text = "TV", icon = R.drawable.tv)
                    }

                    Spacer(modifier = Modifier.height(17.dp))
                    
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MenuTwo(text = "Electricity", icon = R.drawable.electricity)
                        MenuTwo(text = "Internet", icon = R.drawable.internet)
                        MenuTwo(text = "Refer&Earn", icon = R.drawable.referandearn)
                        MenuTwo(text = "More", icon = R.drawable.more)
                    }
                }

            }

        }

}
@Composable
fun MainMenu(text: String, icon:Int, nav: ()-> Unit = {}){
    Column(
        modifier = Modifier
            .padding(3.dp)
            .height(180.dp)
            .width(89.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .height(42.dp)
                .width(42.dp)
                .clickable(onClick = nav),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "menu icon",
                    contentScale = ContentScale.Inside,
                )
            }
        }
        Text(
            text = text,
            modifier = Modifier
                .padding(7.dp),
            color = Color.White,
            fontSize = 13.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuOne(text: String, icon: Int){
    Column(
        modifier = Modifier
            .height(80.dp)
            .width(89.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            onClick = { },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            colors = CardDefaults.cardColors(
                (Color(0xFFf5f5f5))
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "icon description",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                )
            }
        }
        Text(
            text = text,
            modifier = Modifier
                .padding(5.dp),
            color = Color.Black,
            fontSize = 12.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTwo(text : String, icon: Int) {
    Column(
        modifier = Modifier
            .height(80.dp)
            .width(89.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            onClick = { },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            colors = CardDefaults.cardColors(Color(0xFFf5f5f5))
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "icon description",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                )
            }
        }
        Text(
            text = text,
            modifier = Modifier
                .padding(5.dp),
            color = Color.Black,
            fontSize = 12.sp
        )
    }
}