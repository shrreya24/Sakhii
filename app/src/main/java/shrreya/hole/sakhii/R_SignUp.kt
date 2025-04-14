package shrreya.hole.sakhii

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import shrreya.hole.sakhii.ui.theme.Lavender
import shrreya.hole.sakhii.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun R_SignUp(onSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .border(2.dp, color = Lavender, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign Up here",
            style = MaterialTheme.typography.headlineSmall,
            color = Purple80,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Purple80,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80,
                unfocusedLeadingIconColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Purple80,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80,
                unfocusedLeadingIconColor = Color.Gray,
                focusedTrailingIconColor = Purple80,
                unfocusedTrailingIconColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Confirm Password Field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Confirm Password",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    Icon(
                        imageVector = if (confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Purple80,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80,
                unfocusedLeadingIconColor = Color.Gray,
                focusedTrailingIconColor = Purple80,
                unfocusedTrailingIconColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(
            onClick = {
                if (password == confirmPassword) {
                    FirebaseUtils.signUpUser(email, password, onSuccess, { error = it })
                } else {
                    error = "Passwords don't match"
                    Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple80)
        ) {
            Text("Sign Up as Sakhii")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun R_Login(onSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .border(2.dp, color = Lavender, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login here ",
            style = MaterialTheme.typography.headlineSmall,
            color = Purple80,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Purple80,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80,
                unfocusedLeadingIconColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Purple80,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80,
                unfocusedLeadingIconColor = Color.Gray,
                focusedTrailingIconColor = Purple80,
                unfocusedTrailingIconColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(
            onClick = {
                FirebaseUtils.loginUser(email, password, onSuccess, { error = it })
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple80)
        ) {
            Text("Login as Sakhii")
        }
    }
}
