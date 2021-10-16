package my.fitness.myfitness.main_app.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.FragmentProgramBinding
import my.fitness.myfitness.databinding.RegistrationPersonalBinding
import my.fitness.myfitness.program_creation.ProgramCreation0


class Program : Fragment() {
    private var _binding: FragmentProgramBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramBinding.inflate(inflater, container, false)
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