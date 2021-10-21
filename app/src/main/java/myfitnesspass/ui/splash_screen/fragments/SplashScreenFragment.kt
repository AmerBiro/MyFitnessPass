package myfitnesspass.ui.splash_screen.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.AuthLoginBinding
import myfitnesspass.fitness.myfitness.databinding.SplashScreenBinding
import myfitnesspass.ui.BaseFragment

class SplashScreenFragment : BaseFragment(R.layout.splash_screen) {

    private var _binding: SplashScreenBinding? = null
    private val binding get() = _binding!!
    private var duration : Int = 1500
    private var handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SplashScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        accountChecker()
        return view
    }


    private fun accountChecker() {
            var delay = Runnable {
                findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
            }
            handler.postDelayed(delay, duration.toLong())

    }
}