package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.opayclone.AppViewModel
import com.example.opayclone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Deposit(navController: NavController, viewModel: AppViewModel) {
    val addMoney = remember{ mutableStateOf("") }
    val errorMessage = remember{ mutableStateOf("") }
    val accountNumber = remember{ mutableStateOf("") }
    val validatedUser = remember { mutableStateOf("") }
    val next: String = "click here>"
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 84.dp)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Recipient Account",
                modifier = Modifier
            )
            OutlinedTextField(
                value = if(viewModel.showAccountNumber.value) accountNumber.value else "*".repeat(accountNumber.value.length),
                onValueChange = {
                    validatedUser.value = ""
                    accountNumber.value = it
                    if(accountNumber.value.length >=10){
                        val foundUserList = viewModel.users.filter { user-> user.accountNumber == accountNumber.value }

                        if(foundUserList.size <=10) {
                            validatedUser.value = "Enter correct digits"
                        }
                        if(foundUserList.isEmpty()){
                            validatedUser.value = "Account not found"
                        }
                        else{
                            validatedUser.value = foundUserList[0].name
                        }
                    }


                                },
                placeholder = { Text("10-digits account number") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = if(viewModel.showAccountNumber.value) R.drawable.eye else R.drawable.hide),
                        contentDescription = "view account number icon",
                        modifier = Modifier.clickable(
                            onClick = { viewModel.showAccountNumber.value = !viewModel.showAccountNumber.value }
                        )
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    containerColor = Color(0xFFf5f5f5)
                ),
                modifier = Modifier
                    .width(370.dp)
                    .height(54.dp),
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            )
            Text(validatedUser.value)
            Text(
                text = "Enter amount",
                modifier = Modifier
                    .padding(3.dp),
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
                )
            Spacer(modifier = Modifier.height(9.dp))
            OutlinedTextField(
                value = addMoney.value,
                onValueChange = { addMoney.value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(
                        0xFF1CCF9E),
                    unfocusedBorderColor = Color(0xFF1CCF9E),
                    containerColor = Color(0xFFf5f5f5) ),
                placeholder = { Text("100.00-1,000,000.00") } ,
                keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Decimal
            ), 
                leadingIcon = { 
                    Image(painter = painterResource(id = R.drawable.naira),
                        contentDescription = "naira sign",
                        modifier = Modifier.size(15.dp),
                        contentScale = ContentScale.Inside
                    )},
                modifier = Modifier
                    .width(370.dp)
                    .height(54.dp),
                shape = RoundedCornerShape(corner = CornerSize(7.dp))
            )
            Text(text = errorMessage.value, modifier = Modifier.padding(3.dp),
                style = TextStyle(color = Color.Red)
            )
            Text(
                text = "For amount above #1,000,000.00 " + next,
                modifier = Modifier
                    .padding(3.dp),
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(28.dp))


            Button(onClick = {
                if(addMoney.value.length<1){
                    errorMessage.value = "Enter valid amount"
                }
                else{
                    try{
                        val  amountValue = addMoney.value.toDouble()
                        viewModel.addMoney(amountValue)
                        navController.navigate(Screen.Dashboard.route)
                    }
                    catch (e: NumberFormatException){
                        errorMessage.value = "Enter valid amount"
                    }

                }

            }, modifier = Modifier
                .padding(9.dp)
                .height(50.dp)
                .width(372.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color(0xFF1CCF9E),
                    contentColor = Color.White
                )
                ) {
                Text(text = "Next", 
                    modifier = Modifier, 
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}