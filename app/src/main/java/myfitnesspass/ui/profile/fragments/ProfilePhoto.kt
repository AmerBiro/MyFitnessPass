package myfitnesspass.ui.profile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.ui.BaseFragment

class ProfilePhoto : BaseFragment(R.layout.profile_photo) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_photo, container, false)
    }


    /*
     fun buttons(){
        binding.buttonDoneArrow.setOnClickListener{
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.image.setOnClickListener{
            val dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.dialog_choose_photo)
            dialog.show()
        }
        binding.buttonSkip.setOnClickListener{
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
    }

    */
}