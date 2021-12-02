package myfitnesspass.ui.splash_screen.fragments

import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import myfitnesspass.data.remote.others.BasicAuthInterceptor
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.AuthLoginBinding
import myfitnesspass.fitness.myfitness.databinding.SplashScreenBinding
import myfitnesspass.other.Constants
import myfitnesspass.other.Status
import myfitnesspass.ui.BaseFragment
import myfitnesspass.ui.auth.login.viewmodel.LoginViewModel
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment(R.layout.splash_screen) {

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var sharedPref: SharedPreferences

    @Inject
    lateinit var basicAuthInterceptor: BasicAuthInterceptor

    private var curEmail: String? = null
    private var curPassword: String? = null

    private var _binding: SplashScreenBinding? = null
    private val binding get() = _binding!!
    private var duration : Int = 1500
    private var handler = Handler()

    private lateinit var view2: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SplashScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isLoggedIn()){
            authenticateApi(curEmail ?: "", curPassword ?: "")
            redirectLogin()
        }else{
            findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
        }

        view2 = view

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }

    private fun authenticateApi(email: String, password: String) {
        basicAuthInterceptor.email = email
        basicAuthInterceptor.password = password
    }

    private fun isLoggedIn(): Boolean{
        curEmail = sharedPref.getString(
            Constants.KEY_LOGGED_IN_EMAIL,
            Constants.NO_KEY_LOGGED_IN_EMAIL
        ) ?: Constants.NO_KEY_LOGGED_IN_EMAIL
        curPassword = sharedPref.getString(
            Constants.KEY_LOGGED_IN_PASSWORD,
            Constants.NO_KEY_LOGGED_IN_PASSWORD
        ) ?: Constants.NO_KEY_LOGGED_IN_PASSWORD
        return curEmail != Constants.NO_KEY_LOGGED_IN_EMAIL && curPassword != Constants.NO_KEY_LOGGED_IN_PASSWORD
    }

    private fun redirectLogin() {
        findNavController().navigate(R.id.action_splashScreenFragment_to_homeView)
    }

    private fun accountChecker() {
        var delay = Runnable {
            findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
        }
        handler.postDelayed(delay, duration.toLong())
    }
}