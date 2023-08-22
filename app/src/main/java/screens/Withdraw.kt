package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.opayclone.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Withdraw(navController: NavController, viewModel: AppViewModel) {
    val withdraw = remember{ mutableStateOf("") }
    val errorMessage = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 84.dp)
                .padding(12.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(value = withdraw.value,
                onValueChange = { withdraw.value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent, containerColor = Color.LightGray
                ) ,

                modifier = Modifier
                    .width(369.dp)
                    .height(54.dp),
                shape = RoundedCornerShape(corner = CornerSize(25.dp)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal
                )
            )
            Text(text = errorMessage.value)
            Button(onClick = {
                if(withdraw.value.length<1){
                    errorMessage.value = "Enter valid amount"
                }
                else{
                    try{
                        val  amountValue = withdraw.value.toDouble()
                        if(amountValue>viewModel.currentUser.walletBalance) {
                            errorMessage.value = "insufficient funds"
                        }
                        else {
                            viewModel.withdraw(amountValue)
                            navController.navigate(Screen.Dashboard.route)
                        }
                    }
                    catch (e: NumberFormatException){
                        errorMessage.value = "Enter valid amount"
                    }

                }

            }, modifier = Modifier.padding(9.dp)
                .height(50.dp)
                .width(369.dp),
                shape = RoundedCornerShape(corner = CornerSize(25.dp)),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color(0xFF1CCF9E),
                    contentColor = Color.White)
            ) {
                Text(text = "Next")
            }
        }
    }
}