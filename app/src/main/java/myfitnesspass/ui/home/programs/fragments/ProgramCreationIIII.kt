package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIBinding
import myfitnesspass.ui.BaseFragment


class ProgramCreationIIII : BaseFragment(R.layout.fragment_program_creation_i_i_i_i) {


    private var _binding: FragmentProgramCreationIIIIBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIIIBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonNextArrow.setOnClickListener {
            findNavController().navigate(R.id.action_programCreationIIII_to_programCreationIIIII)

        }
        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.autoCompleteTextView.inputType = InputType.TYPE_NULL
        val numberOfDays = resources.getStringArray(R.array.numberOfDay)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,numberOfDays)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        //val x = binding.autoCompleteTextView.sele.toString()


        //get output
        binding.autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()
            // Display the clicked item using toast
            Toast.makeText(requireContext(),"Selected : $selectedItem",Toast.LENGTH_SHORT).show()
        }
        return view

    }


}