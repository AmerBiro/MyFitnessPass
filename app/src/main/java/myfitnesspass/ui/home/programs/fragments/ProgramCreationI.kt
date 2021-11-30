package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.ui.BaseFragment

class ProgramCreationI : BaseFragment(R.layout.fragment_program_creation_i) {

    private var _binding: FragmentProgramCreationIBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramCreationIBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onStart() {
        super.onStart()

        binding.buttonNextArrow.setOnClickListener {
                val action = ProgramCreationIDirections.actionProgramCreationIToProgramCreationII(
                    binding.programName.text.toString(),
                    binding.programDescription.text.toString()
                )
                findNavController().navigate(action)
        }

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }



}