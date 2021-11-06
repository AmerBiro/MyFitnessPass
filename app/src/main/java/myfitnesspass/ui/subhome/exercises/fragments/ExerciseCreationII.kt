package myfitnesspass.ui.subhome.exercises.fragments

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentExerciseCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentExerciseCreationIIBinding
import myfitnesspass.ui.BaseFragment

class ExerciseCreationII : BaseFragment(R.layout.fragment_exercise_creation_i_i) {


    private var _binding: FragmentExerciseCreationIIBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExerciseCreationIIBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonNextArrow.setOnClickListener {

        }

        binding.buttonBackArrow.setOnClickListener {

        }

        binding.autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener{
            parent, view, position, id ->
            val  selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(requireContext(),"Selected : $selectedItem", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    override fun onStart() {
        super.onStart()
        binding.autoCompleteTextView.inputType = InputType.TYPE_NULL
        val exerciseType = resources.getStringArray(R.array.exerciseType)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,exerciseType)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

    }

}