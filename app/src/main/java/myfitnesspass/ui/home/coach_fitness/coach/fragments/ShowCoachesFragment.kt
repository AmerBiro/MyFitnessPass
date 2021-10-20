package myfitnesspass.ui.home.coach_fitness.coach.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.ui.BaseFragment

class ShowCoachesFragment :BaseFragment(R.layout.fragment_coach_show){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coach_show, container, false)
    }
}

