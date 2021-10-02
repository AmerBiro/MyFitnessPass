package my.fitness.myfitness.registration

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationRegistrationBinding

class Registration : Fragment() {

    private var _binding: RegistrationRegistrationBinding? = null
    private val binding get() = _binding!!

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
    }

    override fun onStart() {
        super.onStart()
        buttons()
    }

    fun buttons() {
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_registration_to_personal)
        }
        binding.buttonForgotPassword.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.buttonLogin.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.buttonGoogle.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.buttonFacebook.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
    }
}