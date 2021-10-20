package myfitnesspass.ui.profile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.ui.BaseFragment

class ProfileFragment : BaseFragment(R.layout.profile_view){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_view, container, false)
    }
}