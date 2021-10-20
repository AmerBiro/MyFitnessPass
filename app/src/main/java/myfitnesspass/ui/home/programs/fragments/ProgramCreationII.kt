package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIBinding
import myfitnesspass.ui.BaseFragment

class ProgramCreationII : BaseFragment(R.layout.fragment_program_creation_i_i) {

    private var _binding: FragmentProgramCreationIIBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.buttonNextArrow.setOnClickListener {
           findNavController().navigate(R.id.action_programCreationII_to_programCreationIII)

        }

        return view
    }


}