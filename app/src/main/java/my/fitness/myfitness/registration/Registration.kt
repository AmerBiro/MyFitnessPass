package my.fitness.myfitness.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationRegistrationBinding
import my.fitness.myfitness.functions.User
import my.fitness.myfitness.functions.user.ForgotPassword

class Registration : Fragment() {

    private var _binding: RegistrationRegistrationBinding? = null
    private val binding get() = _binding!!
    private var user: User? = null
    private var forgotPassword : ForgotPassword?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegistrationRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = User()
        forgotPassword = ForgotPassword()
    }

    override fun onStart() {
        super.onStart()
        buttons()
    }

    fun buttons() {
        binding.apply {
            buttonForgotPassword.setOnClickListener {
                forgotPassword?.forgotPassword(requireActivity())
            }

            buttonLogin.setOnClickListener {
                user?.signIn(username, password, it, R.id.action_registration_to_home2, requireActivity()) }

            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_registration_to_personal)
            }
            buttonGoogle.setOnClickListener {
                Toast.makeText(getActivity(), "Not yet implemented", Toast.LENGTH_SHORT).show()
            }
            buttonFacebook.setOnClickListener {
                Toast.makeText(getActivity(), "Not yet implemented", Toast.LENGTH_SHORT).show()
            }
        }

    }
}