package shrreya.hole.sakhii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import shrreya.hole.sakhii.ui.theme.SakhiiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SakhiiTheme {
                var screen by remember { mutableStateOf("choice") }

                when (screen) {
                    "choice" -> Choice(
                        onRiderClick = { screen = "riderStart" },
                        onSakhiiClick = { screen = "sakhiiStart" }
                    )

                    "riderStart" -> R_loginOrSignUp(
                        onLogin = { screen = "riderLogin" },
                        onSignUp = { screen = "riderSignUp" }
                    )

                    "sakhiiStart" -> S_loginOrSignUp(
                        onLogin = { screen = "sakhiiLogin" },
                        onSignUp = { screen = "sakhiiSignUp" }
                    )

                    "riderLogin" -> R_Login(onSuccess = { screen = "home" })
                    "riderSignUp" -> R_SignUp(onSuccess = { screen = "home" })

                    "sakhiiLogin" -> S_Login(onSuccess = { screen = "home" })
                    "sakhiiSignUp" -> S_SignUp(onSuccess = { screen = "home" })

                    "home" -> Text("Welcome to the app!")
                }
            }
        }
    }
}
