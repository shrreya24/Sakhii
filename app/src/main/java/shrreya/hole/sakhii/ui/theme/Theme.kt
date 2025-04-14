package shrreya.hole.sakhii.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import shrreya.hole.sakhii.R

// 1. Font family setup
val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_regular, FontWeight.Normal),
    Font(R.font.nunito_sans_bold, FontWeight.Bold)
)

// 2. Lavender color setup
val Lavender = Color(0xFFE6E6FA)

// 3. Custom typography using Nunito Sans
val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )
)

// 4. Custom color scheme with lavender as primary
private val CustomColorScheme = lightColorScheme(
    primary = Lavender,
    onPrimary = Color.Black // text color on buttons
)

@Composable
fun SakhiiTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomColorScheme,
        typography = AppTypography,
        content = content
    )
}
