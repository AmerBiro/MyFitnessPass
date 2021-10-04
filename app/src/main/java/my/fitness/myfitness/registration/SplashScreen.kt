package my.fitness.myfitness.registration

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationSplashScreenBinding


class RegistrationSplashScreen : Fragment() {

    private var _binding: RegistrationSplashScreenBinding? = null
    private val binding get() = _binding!!
    private var user = FirebaseAuth.getInstance().currentUser
    private var delay = Handler()
    private var duration : Int?= null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegistrationSplashScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        autoSignIn()
    }


    fun autoSignIn() {
        var accountStatus = binding.accountStatus
        accountStatus.text = "Checking account..."

        var x = Runnable {
            findNavController().navigate(R.id.action_registrationSplashScreen_to_registration)
        }

        var y = Runnable {
            findNavController().navigate(R.id.action_registrationSplashScreen_to_home2)
        }

        var z = Runnable {
            if (user == null) {
                accountStatus.text = "No account founded!"
                duration = (100..1000).random()
                delay.postDelayed(x, duration!!.toLong())
                Log.d(TAG, "autoSignIn: $duration")
            } else {
                accountStatus.text = "Logging in..."
                duration = (250..1250).random()
                delay.postDelayed(y, duration!!.toLong())
                Log.d(TAG, "autoSignIn: $duration")
            }
        }
        duration = (1500..2000).random()
        delay.postDelayed(z, duration!!.toLong())
        Log.d(TAG, "autoSignIn: $duration")


    }


}