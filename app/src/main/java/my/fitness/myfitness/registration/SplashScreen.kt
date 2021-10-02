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

    private var _binding: RegistrationSplashScreenBinding? = null
    private val binding get() = _binding!!


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
        handler()
    }

    fun handler() {
        var x = Runnable {
            findNavController().navigate(R.id.registration)
        }

        var y = Handler()
        y.postDelayed(x, 3000)
    }


}