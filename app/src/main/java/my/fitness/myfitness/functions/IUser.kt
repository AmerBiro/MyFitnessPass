package my.fitness.myfitness.functions

import android.app.Activity
import android.view.View
import androidx.navigation.NavController

interface IUser {

    fun createUser(username : String, password : String)

    fun signIn(username: String, password: String, view : View, destination : Int)

    fun signOut()

    fun verify()

    fun updateEmail()

    fun resetPassword()

    fun deleteUser()
}