package myfitnesspass.ui.home.programs.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIIBinding
import myfitnesspass.ui.BaseFragment

class ProgramCreationIIIII : BaseFragment(R.layout.fragment_program_creation_i_i_i_i_i) {

    private var _binding: FragmentProgramCreationIIIIIBinding? = null
    private val binding get() = _binding!!

    val args: ProgramCreationIIIIIArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramCreationIIIIIBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d(TAG, "onViewCreated: ${args.programName}, ${args.programDes}, ${args.startDate}, ${args.endDate}, ${args.item}")
    }

    override fun onStart() {
        super.onStart()

        binding.buttonDone.setOnClickListener {
            findNavController().navigate(R.id.action_programCreationIIIII_to_homeView)
        }

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

}