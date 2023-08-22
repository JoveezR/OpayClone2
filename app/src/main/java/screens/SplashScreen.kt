package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.opayclone.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navigateToLoginScreen:  ()-> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        coroutineScope.launch() {
            delay(2000)
            navigateToLoginScreen()
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(
        listOf(
            Color(0xff1DB764),
            Color(0Xff272660)
        )
    )), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(contentDescription ="opay logo", painter = painterResource(id = R.drawable.opay),
            modifier = Modifier
                .padding(9.dp)
                .clip(CircleShape)
                .size(40.dp)
            )
        Column(modifier = Modifier.fillMaxWidth().padding(top = 14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "We are Beyond Banking",
                modifier = Modifier.padding(),
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = Color.Blue),
                fontSize = 31.sp
            )
            Row {
                Text(
                    text = "LICENSED BY CBN AND INSURED BY",
                    modifier = Modifier.padding(),
                    fontWeight = FontWeight.Thin,
                    style = TextStyle(color = Color.Blue),
                    fontSize = 17.sp
                )
                Text(
                    text = "NDIC",
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(color = Color.Blue),
                    fontSize = 25.sp
                )
            }
        }

    }
}