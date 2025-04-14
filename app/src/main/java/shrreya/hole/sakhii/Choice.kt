package shrreya.hole.sakhii

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Choice(
    onRiderClick: () -> Unit,
    onSakhiiClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "Welcome to Sakhii",
                style = MaterialTheme.typography.titleLarge
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = onRiderClick) {
                    Text(text = "I am a Rider")
                }
                Button(onClick = onSakhiiClick) {
                    Text(text = "I am a Sakhii")
                }
            }
        }
    }
}
