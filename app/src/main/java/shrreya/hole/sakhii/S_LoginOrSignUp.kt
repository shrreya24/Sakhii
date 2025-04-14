package shrreya.hole.sakhii


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shrreya.hole.sakhii.ui.theme.Lavender

@Composable
fun S_loginOrSignUp(onLogin: () -> Unit, onSignUp: () -> Unit) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("To Proceed, Please Login Or Sign Up")

        Button(onClick = onLogin) {
            Text("Sign In")
        }
        Button(onClick = onSignUp) {
            Text("Sign Up")
        }
    }
}

