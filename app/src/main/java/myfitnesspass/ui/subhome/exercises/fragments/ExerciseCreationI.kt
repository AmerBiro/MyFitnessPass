package myfitnesspass.ui.subhome.exercises.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentExerciseCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentShowExercisesBinding
import myfitnesspass.ui.BaseFragment


class ExerciseCreationI : BaseFragment(R.layout.fragment_exercise_creation_i) {


    private var _binding: FragmentExerciseCreationIBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExerciseCreationIBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonNextArrow.setOnClickListener {
            findNavController().navigate(R.id.action_exerciseCreationI_to_exerciseCreationII)
        }

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }



        return view
    }

}