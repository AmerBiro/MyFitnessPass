package myfitnesspass.ui.home.programs.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_program_creation_i.*
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIBinding
import myfitnesspass.ui.BaseFragment


class ProgramCreationIIII : BaseFragment(R.layout.fragment_program_creation_i_i_i_i) {

    private var _binding: FragmentProgramCreationIIIIBinding? = null
    private val binding get() = _binding!!

    private var item: String = ""

    val args: ProgramCreationIIIIArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramCreationIIIIBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Log.d(TAG, "onViewCreated: ${args.programName}, ${args.programDes}, ${args.startDate}, ${args.endDate}")
    }


    override fun onStart() {
        super.onStart()

        binding.buttonNextArrow.setOnClickListener {
//            Log.d(TAG, "onStart: $item")
            val action =
                ProgramCreationIIIIDirections.actionProgramCreationIIIIToProgramCreationIIIII(
                    args.programName,
                    args.programDes,
                    args.startDate,
                    args.endDate,
                    item
                )
            findNavController().navigate(action)
        }

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }

        //get output
        binding.autoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = parent.getItemAtPosition(position).toString()
                item = selectedItem
                // Display the clicked item using toast
                Toast.makeText(requireContext(), "Selected : $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

        binding.autoCompleteTextView.inputType = InputType.TYPE_NULL
        val programType = resources.getStringArray(R.array.programType)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, programType)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        //val x = binding.autoCompleteTextView.sele.toString()

    }


}