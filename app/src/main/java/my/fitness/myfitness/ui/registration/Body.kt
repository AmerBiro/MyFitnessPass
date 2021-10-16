package my.fitness.myfitness.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.AuthLoginBinding

class Body : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
//        mover()
    }

//    fun mover(){
//        binding.buttonNextArrow.setOnClickListener{
//            findNavController().navigate(R.id.action_body2_to_membership)
//        }
//        binding.buttonSkip.setOnClickListener{
//            findNavController().navigate(R.id.action_body2_to_membership)
//        }
//    }
}