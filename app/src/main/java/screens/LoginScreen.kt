package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun LoginScreen(navController: NavController, viewModel: AppViewModel) {
    var username = remember{ mutableStateOf("") }
    var password = remember{ mutableStateOf("") }
    var errorMessage = remember{ mutableStateOf("") }
    var isRemember = remember {
        mutableStateOf(false)
    }
    viewModel.showTopBar.value = false
    val spaceSize = 20.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center ) {
            Text(
                text = "Welcome back!",
                modifier = Modifier
                    .padding(top = 72.dp),
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(color = Color.Black),
                fontSize = 29.sp
            )
        }
        Spacer(modifier = Modifier.height(spaceSize))
        OutlinedTextField(
            value = username.value,
            onValueChange = {username.value = it},
            placeholder = {Text("Enter username") },
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(0xFF1CCF9E)),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .width(370.dp)
                .height(54.dp)
            )

       Spacer(modifier = Modifier.height(22.dp))

     Column(
         modifier = Modifier.padding(6.dp),
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         OutlinedTextField(
             value = if(viewModel.showPassword.value) password.value else "*".repeat(password.value.length),
             onValueChange = { password.value = it },
             placeholder = { Text("Enter 6 digits password") },
             keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
             trailingIcon = {
                 Image(
                     painter = painterResource(id = if(viewModel.showPassword.value) R.drawable.eye else R.drawable.hide),
                     contentDescription = "view password icon",
                     modifier = Modifier.clickable(
                         onClick = { viewModel.showPassword.value = !viewModel.showPassword.value }
                     )
                 )
             },
             colors = TextFieldDefaults.outlinedTextFieldColors(
                 unfocusedBorderColor = Color(
                     0xFF1CCF9E
                 ),
             ),
             modifier = Modifier
                 .width(370.dp)
                 .height(54.dp)
         )

         Text(
             text = errorMessage.value, modifier = Modifier.padding(3.dp),
             style = TextStyle(color = Color.Red)
         )
         Spacer(modifier = Modifier.height(4.dp))
         Row(
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(13.dp),
             horizontalArrangement = Arrangement.spacedBy(82.dp),
             verticalAlignment = Alignment.CenterVertically
         ) {
             Row(
                 modifier = Modifier
                     .width(166.dp)
                     .padding(2.dp),
                 horizontalArrangement = Arrangement.spacedBy(22.dp)
             ) {
                 Checkbox(
                     checked = isRemember.value,
                     onCheckedChange = { isRemember.value = !isRemember.value },
                     modifier = Modifier
                         .size(0.3.dp).padding(6.dp),
                     colors = CheckboxDefaults.colors(Color.LightGray)
                 )

                 Text(
                     text = "Remember Password",
                     modifier = Modifier,
                     fontSize = 14.sp,
                     color = Color.Black
                 )
             }
             //Spacer(modifier = Modifier.width(70.dp))
             Text(
                 text = "Forgot Password?",
                 modifier = Modifier,
                 fontSize = 14.sp,
                 fontWeight = FontWeight.SemiBold,
                 color = Color(0xFF1CCF9E)
             )

         }
         Button(
             onClick = {
                 if (password.value.length != 6) {
                     errorMessage.value = "password must be six characters"
                 } else if (username.value.isEmpty()) {
                     errorMessage.value = "no user"
                 } else {
                     val matchedUser = viewModel.users.filter { it.username == username.value }
                     if (matchedUser.isNotEmpty()) {
                         val user = matchedUser[0];
                         if (user.password == password.value) {
                             viewModel.currentUser = matchedUser[0]

                             navController.navigate(Screen.Dashboard.route)
                         } else {
                             errorMessage.value = "Incorrect Password!"
                         }

                     } else {
                         errorMessage.value = "no user found"
                     }
                 }
             }, modifier = Modifier
                 .padding(12.dp)
                 .width(370.dp),
             shape = RoundedCornerShape(corner = CornerSize(10.dp)),
             colors = ButtonDefaults.filledTonalButtonColors(
                 containerColor = Color(0xFF1CCF9E),
                 contentColor = Color.White
             )
         ) {
             Text(
                 text = "Sign in", modifier = Modifier
                     .padding(3.dp)
                     .align(Alignment.CenterVertically)

             )

         }
     }

    }
}