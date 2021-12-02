package myfitnesspass.ui.home.programs.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentUpdateProgramBinding
import myfitnesspass.ui.BaseFragment

class UpdateProgramFragment : BaseFragment(R.layout.fragment_update_program) {


    private var _binding: FragmentUpdateProgramBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateProgramBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }


//        binding.linearEditProgramName.setOnClickListener {
//            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationI)
//        }

//        binding.buttonDateProgram.setOnClickListener {
//            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationII)
//        }
//
//        binding.buttonCoachProgram.setOnClickListener {
//            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationIIII)
//        }
//
//        binding.buttonFitnessProgram.setOnClickListener {
//            findNavController().navigate(R.id.action_updateProgramFragment_to_programCreationIIIII)
//        }

        showEditTextName()
        showEditTextDescription()
        return view
    }


    private fun showEditTextName(){
        binding.linearEditProgramName.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val inflater = requireActivity().layoutInflater
            val dialogLayout = inflater.inflate(R.layout.edit_text_layout,null)
            val editText = dialogLayout.findViewById<EditText>(R.id.edit_text_bt)

            with(builder){
                setTitle("Enter program name!")
                setPositiveButton("Ok"){dialog,which ->
                    binding.textViewName.text= editText.text.toString()
                }
                setNegativeButton("Cancel"){dialog,which ->
                    Log.d("Main","Negative button clicked")
                }
                setView(dialogLayout)
                show()
            }
        }
    }


    private fun showEditTextDescription(){
        binding.linearEditProgramDescription.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val inflater = requireActivity().layoutInflater
            val dialogLayout = inflater.inflate(R.layout.edit_text_layout,null)
            val editText = dialogLayout.findViewById<EditText>(R.id.edit_text_bt)

            with(builder){
                setTitle("Enter a new Description!")
                setPositiveButton("Ok"){dialog,which ->
                    binding.textViewDec.text= editText.text.toString()
                }
                setNegativeButton("Cancel"){dialog,which ->
                    Log.d("Main","Negative button clicked")
                }
                setView(dialogLayout)
                show()
            }
        }
    }

}