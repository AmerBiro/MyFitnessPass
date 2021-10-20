package myfitnesspass.ui.profile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.ui.BaseFragment

class ProfileGender : BaseFragment(R.layout.profile_gender_birth){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_gender_birth, container, false)
    }
}