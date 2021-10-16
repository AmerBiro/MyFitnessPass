package myfitnesspass.basic.home.programs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramViewBinding


class ProgramView : Fragment() {

    private var _binding: FragmentProgramViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramViewBinding.inflate(inflater, container, false)
        val view = binding.root

        //todo
        /*
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_program2_to_programCreation0)
        }

         */

        return view
    }


}