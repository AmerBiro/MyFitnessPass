package myfitnesspass.ui.profile.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.ProfilePhotoBinding
import myfitnesspass.fitness.myfitness.databinding.ProfileViewBinding
import myfitnesspass.other.Constants.KEY_LOGGED_IN_EMAIL
import myfitnesspass.other.Constants.KEY_LOGGED_IN_PASSWORD
import myfitnesspass.other.Constants.NO_KEY_LOGGED_IN_EMAIL
import myfitnesspass.other.Constants.NO_KEY_LOGGED_IN_PASSWORD
import myfitnesspass.ui.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment(R.layout.profile_view){

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private var _binding: ProfileViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileViewBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lodOut.setOnClickListener{
            logout()
        }
    }


    private fun logout(){
        sharedPreferences.edit().putString(KEY_LOGGED_IN_EMAIL, NO_KEY_LOGGED_IN_EMAIL).apply()
        sharedPreferences.edit().putString(KEY_LOGGED_IN_PASSWORD, NO_KEY_LOGGED_IN_PASSWORD).apply()
//        val navOptions =  NavOptions.Builder()
//            .setPopUpTo(R.id.homeView, true)
//            .build()
//        findNavController().navigate(
//            R.id.loginFragment, navOptions
//        )
        findNavController().navigate(R.id.action_homeView_to_loginFragment)
    }








}