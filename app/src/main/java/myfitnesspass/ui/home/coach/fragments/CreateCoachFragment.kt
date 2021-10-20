package myfitnesspass.ui.home.coach.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentCoachCreateBinding
import myfitnesspass.ui.BaseFragment

class CreateCoachFragment: BaseFragment(R.layout.fragment_coach_create) {


    private var _binding: FragmentCoachCreateBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoachCreateBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

}