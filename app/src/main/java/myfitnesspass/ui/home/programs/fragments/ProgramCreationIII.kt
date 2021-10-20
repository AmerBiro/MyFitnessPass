package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIBinding
import myfitnesspass.ui.BaseFragment

class ProgramCreationIII : BaseFragment(R.layout.fragment_program_creation_i_i_i){

    private var _binding: FragmentProgramCreationIIIBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIIBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.doneButton.setOnClickListener {
            findNavController().navigate(R.id.action_programCreationIII_to_homeView)

        }

        return view
    }

}