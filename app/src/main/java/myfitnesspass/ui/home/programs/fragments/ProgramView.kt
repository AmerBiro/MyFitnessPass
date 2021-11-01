package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramViewBinding
import myfitnesspass.ui.BaseFragment

class ProgramView : BaseFragment(R.layout.fragment_program_view) {

    private var _binding: FragmentProgramViewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramViewBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.addDayButton.setOnClickListener {
            findNavController().navigate(R.id.action_programView_to_dayCreationI)
        }

        binding.programImageButton.setOnClickListener {
            requireActivity().onBackPressed()
        }


        return view
    }

}