package myfitnesspass.ui.subhome.programdays.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentDayCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramViewBinding
import myfitnesspass.ui.BaseFragment

class DayCreationI : BaseFragment(R.layout.fragment_day_creation_i) {

    private var _binding: FragmentDayCreationIBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDayCreationIBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.buttonDoneArrow.setOnClickListener {
        requireActivity().onBackPressed()
        //findNavController().navigate(R.id.action_dayCreationI_to_programView)
        }


        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }



        return view
    }
}