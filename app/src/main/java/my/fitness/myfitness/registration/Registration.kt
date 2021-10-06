package my.fitness.myfitness.registration

import android.app.Dialog
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationRegistrationBinding
import my.fitness.myfitness.functions.User

class Registration : Fragment() {

    private var _binding: RegistrationRegistrationBinding? = null
    private val binding get() = _binding!!
    private val ref = FirebaseAuth.getInstance()
    private var user: User? = null

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
    }

    override fun onStart() {
        super.onStart()
        buttons()
    }

    fun buttons() {
        binding.apply {
            buttonForgotPassword.setOnClickListener {
                val dialog = Dialog(requireActivity())
                dialog.setContentView(R.layout.dialog_forgot_password)
                dialog.show()

            }
            buttonLogin.setOnClickListener {
                user?.signIn(
                    username.text.toString().trim(),
                    password.text.toString().trim(),
                    it,
                    R.id.action_registration_to_home2
                )
            }
            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_registration_to_personal)
            }
            buttonGoogle.setOnClickListener {
                Toast.makeText(getActivity(), "Not yet implemented", 0).show()
            }
            buttonFacebook.setOnClickListener {
                Toast.makeText(getActivity(), "Not yet implemented", 0).show()
            }
        }

    }
}