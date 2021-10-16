package my.fitness.myfitness.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.ProfileMembershipBinding

class Membership : Fragment() {

    private var _binding: ProfileMembershipBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileMembershipBinding.inflate(inflater, container, false)
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
//            findNavController().navigate(R.id.action_membership_to_caoch2)
//        }
//        binding.buttonSkip.setOnClickListener{
//            findNavController().navigate(R.id.action_membership_to_caoch2)
//        }
//    }
}