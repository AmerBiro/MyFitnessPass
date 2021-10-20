package myfitnesspass.ui.auth.sign_up.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.AuthSignUpBinding
import myfitnesspass.ui.BaseFragment

class SignUpFragment: BaseFragment(R.layout.auth_sign_up) {

    private var _binding: AuthSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AuthSignUpBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }
}