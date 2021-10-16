package myfitnesspass.basic.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.databinding.RegistrationPersonal2Binding

class Personal2 : Fragment() {

    private var _binding: RegistrationPersonal2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegistrationPersonal2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
//        buttons()
    }

//    fun buttons(){
//        binding.buttonNextArrow.setOnClickListener{
//            findNavController().navigate(R.id.action_personal2_to_body2)
//        }
//        binding.buttonMale.setOnClickListener{
//            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
//        }
//        binding.buttonFemale.setOnClickListener{
//            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
//        }
//    }
}