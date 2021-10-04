package my.fitness.myfitness.registration

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationRegistrationBinding

class Registration : Fragment() {

    private var _binding: RegistrationRegistrationBinding? = null
    private val binding get() = _binding!!
    private val ref = FirebaseAuth.getInstance()

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
            ref.createUserWithEmailAndPassword(
                binding.username.text.toString().trim(),
                binding.password.text.toString().trim()
            ).addOnCompleteListener{
                findNavController().navigate(R.id.action_registration_to_home2)
                Toast.makeText(activity, "Not yet implemented", 0).show()
            }
        }
        binding.buttonForgotPassword.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.buttonLogin.setOnClickListener {
            ref.signInWithEmailAndPassword(
                binding.username.text.toString().trim(),
                binding.password.text.toString().trim()
            ).addOnCompleteListener{
                Toast.makeText(activity, "Not yet implemented", 0).show()
                findNavController().navigate(R.id.action_registration_to_home2)
            }
        }
        binding.buttonGoogle.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.buttonFacebook.setOnClickListener {
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
    }
}