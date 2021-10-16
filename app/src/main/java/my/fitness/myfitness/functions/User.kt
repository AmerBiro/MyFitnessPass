package my.fitness.myfitness.functions

import android.app.Activity
import android.view.View
import android.widget.EditText

class User : IUser {
    override fun createUser(
        username: EditText,
        password: EditText,
        view: View,
        destination: Int,
        activity: Activity
    ) {
        TODO("Not yet implemented")
    }

    override fun signIn(
        username: EditText,
        password: EditText,
        view: View,
        destination: Int,
        activity: Activity
    ) {
        TODO("Not yet implemented")
    }

    override fun signOut(view: View, destination: Int, activity: Activity) {
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