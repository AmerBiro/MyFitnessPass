package my.fitness.myfitness.functions

import android.app.Activity
import android.view.View
import android.widget.EditText

interface IUser {

    fun createUser(username: EditText, password: EditText, view: View, destination: Int, activity : Activity)

    fun signIn(username: EditText, password: EditText, view: View, destination: Int, activity : Activity)

    fun signOut(view: View, destination: Int, activity: Activity)

    fun verify()

    fun updateEmail()

    fun resetPassword()

    fun deleteUser()
}