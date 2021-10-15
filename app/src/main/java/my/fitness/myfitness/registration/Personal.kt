package my.fitness.myfitness.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationPersonalBinding

class Personal : Fragment() {

    private var _binding: RegistrationPersonalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegistrationPersonalBinding.inflate(inflater, container, false)
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

    fun buttons(){
        binding.buttonBackArrow.setOnClickListener {
           // findNavController().navigate(R.id.action_personal_to_registration)
            requireActivity().onBackPressed()
        }

        binding.buttonSignup.setOnClickListener {
            findNavController().navigate(R.id.action_personal_to_home2)
        }


    }
}