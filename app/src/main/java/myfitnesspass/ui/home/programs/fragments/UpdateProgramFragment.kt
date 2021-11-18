package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentUpdateProgramBinding
import myfitnesspass.ui.BaseFragment

class UpdateProgramFragment : BaseFragment(R.layout.fragment_update_program) {


    private var _binding: FragmentUpdateProgramBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateProgramBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.linearEditProgramName.setOnClickListener {
            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationI)
        }

        binding.buttonDateProgram.setOnClickListener {
            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationII)
        }

        binding.buttonCoachProgram.setOnClickListener {
            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationIIII)
        }
        
        binding.buttonFitnessProgram.setOnClickListener {
            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationIIIII)
        }



        return view
    }

}