package myfitnesspass.ui.auth.login.fragments

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import my.myfitness.myfitnesspass.data.remote.others.BasicAuthInterceptor
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.AuthLoginBinding
import myfitnesspass.other.Constants.KEY_LOGGED_IN_EMAIL
import myfitnesspass.other.Constants.KEY_LOGGED_IN_PASSWORD
import myfitnesspass.other.Constants.NO_KEY_LOGGED_IN_EMAIL
import myfitnesspass.other.Constants.NO_KEY_LOGGED_IN_PASSWORD
import myfitnesspass.other.Status
import myfitnesspass.ui.BaseFragment
import myfitnesspass.ui.auth.login.viewmodel.LoginViewModel
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.auth_login) {

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var sharedPref: SharedPreferences

    @Inject
    lateinit var basicAuthInterceptor: BasicAuthInterceptor

    private var curEmail: String? = null
    private var curPassword: String? = null

    private var _binding: AuthLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var view2: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AuthLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isLoggedIn()){
            authenticateApi(curEmail ?: "", curPassword ?: "")
            redirectLogin()
        }

        view2 = view

        requireActivity().requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        subscribeToObservers()

        binding.buttonLogin.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            curEmail = email
            curPassword = password

            viewModel.login(email, password)
        }
    }

    private fun authenticateApi(email: String, password: String) {
        basicAuthInterceptor.email = email
        basicAuthInterceptor.password = password
    }

    private fun isLoggedIn(): Boolean{
        curEmail = sharedPref.getString(KEY_LOGGED_IN_EMAIL, NO_KEY_LOGGED_IN_EMAIL) ?: NO_KEY_LOGGED_IN_EMAIL
        curPassword = sharedPref.getString(KEY_LOGGED_IN_PASSWORD, NO_KEY_LOGGED_IN_PASSWORD) ?: NO_KEY_LOGGED_IN_PASSWORD
        return curEmail != NO_KEY_LOGGED_IN_EMAIL && curPassword != NO_KEY_LOGGED_IN_PASSWORD
    }

    private fun redirectLogin() {
        findNavController().navigate(R.id.action_loginFragment_to_homeView)
    }

    private fun subscribeToObservers() {
        viewModel.loginStatus.observe(viewLifecycleOwner, Observer { result ->
            result?.let {
                when(result.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        showSnackBar(view2, result.data ?: "Successfully logged in")
                        sharedPref.edit().putString(KEY_LOGGED_IN_EMAIL, curEmail).apply()
                        sharedPref.edit().putString(KEY_LOGGED_IN_PASSWORD, curPassword).apply()
                        authenticateApi(curEmail ?: "", curPassword ?: "")
//                        findNavController().navigate(R.id.action_loginFragment_to_homeView)
                        redirectLogin()
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        showSnackBar(view2, result.message ?: "An unknown error occured")
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })

    }
}