package myfitnesspass.ui.subhome.exercises.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.ui.BaseFragment


class ExerciseCreationI : BaseFragment(R.layout.fragment_exercise_creation_i) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_creation_i, container, false)
    }

}