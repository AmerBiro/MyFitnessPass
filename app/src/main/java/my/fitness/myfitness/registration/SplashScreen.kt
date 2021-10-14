package my.fitness.myfitness.registration

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationSplashScreenBinding


class RegistrationSplashScreen : Fragment() {

    private lateinit var _binding: RegistrationSplashScreenBinding
    private val binding get() = _binding!!
    private var user = null
    private var handler = Handler()
    private var duration : Int = 1500

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
        if (user != null){
            findNavController().navigate(R.id.action_registrationSplashScreen_to_home2)
        }else{
            var delay = Runnable {
                findNavController().navigate(R.id.action_registrationSplashScreen_to_registration)
            }
            handler.postDelayed(delay, duration.toLong())
        }
    }


}