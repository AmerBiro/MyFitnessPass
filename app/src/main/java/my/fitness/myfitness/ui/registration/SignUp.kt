package my.fitness.myfitness.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.AuthSignUpBinding

class SignUp : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
//        arrows()

    }

/*    fun arrows(){
        binding.buttonBackArrow.setOnClickListener {
            findNavController().navigate(R.id.action_personal_to_registration)
        }
        binding.buttonNextArrow.setOnClickListener {
            findNavController().navigate(R.id.action_personal_to_personal2)
        }
    }*/
}