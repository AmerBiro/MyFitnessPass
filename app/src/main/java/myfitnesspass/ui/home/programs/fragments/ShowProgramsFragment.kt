package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramShowBinding
import myfitnesspass.ui.BaseFragment

class ShowProgramsFragment: BaseFragment(R.layout.fragment_program_show) {

    private var _binding: FragmentProgramShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramShowBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.addButton.setOnClickListener {
              findNavController().navigate(R.id.action_homeView_to_programCreationI)

        }



        return view
    }
}