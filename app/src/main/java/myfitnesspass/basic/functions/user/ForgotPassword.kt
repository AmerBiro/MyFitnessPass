package myfitnesspass.basic.functions.user

import android.app.Activity
import android.app.Dialog
import android.widget.EditText
import android.widget.TextView
import myfitnesspass.fitness.myfitness.R

class ForgotPassword {

    fun forgotPassword(activity: Activity) {
        // initializing alert dialog
        val dialog = Dialog(activity)
        dialog.setContentView(R.layout.dialog_forgot_password)
        dialog.show()

        // binding buttons to layout
        var inputE: EditText = dialog.findViewById(R.id.dialog_forgot_password_email)
        var cancelButton: TextView = dialog.findViewById(R.id.dialog_forgot_password_cancel)
        var resetButton: TextView = dialog.findViewById(R.id.dialog_forgot_password_reset)

        // closing alert dialog
        cancelButton.setOnClickListener {
            dialog.cancel()
        }

        // reset password function
        resetButton.setOnClickListener {
            var input = inputE.text.toString()
//            if (input.trim().isNotEmpty()){
//                user.sendPasswordResetEmail(input).addOnSuccessListener {
//                    Log.d(TAG, "forgotPassword: successfully")
//                    Toast.makeText(activity, "We've sent you a reset password link", 0).show()
//                    dialog.cancel()
//                }.addOnFailureListener {
//                    Log.d(TAG, "forgotPassword: ${it.message}")
//                    Toast.makeText(activity, "Reset password failed", 0).show()
//                }
//            }else
//                Toast.makeText(activity, "Invalid input!", 0).show()
        }

    }

}