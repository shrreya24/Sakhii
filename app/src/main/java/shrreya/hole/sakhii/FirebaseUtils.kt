
package shrreya.hole.sakhii

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object FirebaseUtils {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signUpUser(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) onSuccess()
                else onFailure(task.exception?.message ?: "Signup Failed")
            }
    }

    fun loginUser(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) onSuccess()
                else onFailure(task.exception?.message ?: "Login Failed")
            }
    }

    fun getCurrentUser(): FirebaseUser? = auth.currentUser
}
