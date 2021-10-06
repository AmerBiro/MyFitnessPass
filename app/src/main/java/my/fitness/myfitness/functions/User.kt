package my.fitness.myfitness.functions

import android.app.Activity
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth

class User : IUser {

    private var user: FirebaseAuth = FirebaseAuth.getInstance()

    override fun createUser(username: EditText, password: EditText, view: View, destination: Int, activity : Activity) {
        user.createUserWithEmailAndPassword(
            username.text.toString().trim(),
            password.text.toString().trim()
        )
            .addOnSuccessListener {
                Log.d(TAG, "signIn: successfully")
                Toast.makeText(activity, "Sign in successfully", 0).show()
                view.findNavController().navigate(destination)
            }.addOnFailureListener {
                Log.d(TAG, "signIn: ${it.message}")
                Toast.makeText(activity, "Sign in error", 0).show()
            }
    }

    override fun signIn(usernameE: EditText, passwordE: EditText, view: View, destination: Int, activity : Activity) {
        var username = usernameE.text.toString().trim()
        var password = passwordE.text.toString().trim()
        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(activity, "Invalid input!", 0).show()
            return
        }

        user.signInWithEmailAndPassword(username, password)
            .addOnSuccessListener {
                Log.d(TAG, "signIn: successfully")
                view.findNavController().navigate(destination)
                Toast.makeText(activity, "Sign in successfully", 0).show()
            }.addOnFailureListener {
                Toast.makeText(activity, "Sign in error: ${it.message}", 0).show()
                Log.d(TAG, "signIn: ${it.message}")
            }
    }

    override fun signOut(view: View, destination: Int, activity: Activity) {
        if (user.currentUser != null){
            user.signOut()
            view.findNavController().navigate(destination)
            Toast.makeText(activity, "Sign out successfully", 0).show()
            Log.d(TAG, "signOut: successfully")
        }else{
            Toast.makeText(activity, "Sign out error", 0).show()
            Log.d(TAG, "signOut: error")
        }
    }

    override fun verify() {
        TODO("Not yet implemented")
    }

    override fun updateEmail() {
        TODO("Not yet implemented")
    }

    override fun resetPassword() {
        TODO("Not yet implemented")
    }

    override fun deleteUser() {
        TODO("Not yet implemented")
    }


}