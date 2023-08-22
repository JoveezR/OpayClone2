package screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.opayclone.AppViewModel

/*fun passwordInput() {
    var passwordVisible by remember{ mutableStateOf(false) }
    var passWordText by remember{ mutableStateOf("") }

    val passwordVisualTransformation = if(passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    val passwordTrailingIcon = if(passwordVisible) {
        Icons.Filled.hashCode()
    }
    BasicTextField(value = passWordText) {
        onValueChange = {passWordText = it},
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun passwordInputScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Password Input") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            passwordInput()
        }

    }
*/