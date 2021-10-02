package my.fitness.myfitness.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.RegistrationProfilePhotoBinding

class ProfilePhoto : Fragment() {

    private var _binding: RegistrationProfilePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegistrationProfilePhotoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        buttons()
    }

    fun buttons(){
        binding.buttonDoneArrow.setOnClickListener{
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.placeHolder.setOnClickListener{
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
        binding.buttonSkip.setOnClickListener{
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
    }


}