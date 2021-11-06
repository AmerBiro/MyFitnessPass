package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIIBinding
import myfitnesspass.ui.BaseFragment

class ProgramCreationIIIII : BaseFragment(R.layout.fragment_program_creation_i_i_i_i_i) {

    private var _binding: FragmentProgramCreationIIIIIBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIIIIBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonDone.setOnClickListener {
            findNavController().navigate(R.id.action_programCreationIIIII_to_homeView)

        }

        binding.buttonBackArrow.setOnClickListener {
           requireActivity().onBackPressed()

        }



        return view
    }

}