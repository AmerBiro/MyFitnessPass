package my.fitness.myfitness.functions

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth

class User : IUser {

    private var user : FirebaseAuth = FirebaseAuth.getInstance()

    override fun createUser(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun signIn(username: String, password: String, view : View, destination : Int) {
        user.signInWithEmailAndPassword(username, password)
            .addOnSuccessListener{
                Log.d(TAG, "signIn: successfully")
            view.findNavController().navigate(destination)
            }.addOnFailureListener{
            Log.d(TAG, "signIn: ${it.message}")
        }
    }

    override fun signOut() {
        TODO("Not yet implemented")
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