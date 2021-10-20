package myfitnesspass.ui.auth.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.AuthLoginBinding
import myfitnesspass.ui.BaseFragment

class LoginFragment: BaseFragment(R.layout.auth_login) {

    private var _binding: AuthLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AuthLoginBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}