package my.fitness.myfitness.ui.registration

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import my.fitness.myfitness.R
import my.fitness.myfitness.databinding.ProfilePhotoBinding

class ProfilePhoto : Fragment() {

    private var _binding: ProfilePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfilePhotoBinding.inflate(inflater, container, false)
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
        binding.image.setOnClickListener{
            val dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.dialog_choose_photo)
            dialog.show()
        }
        binding.buttonSkip.setOnClickListener{
            Toast.makeText(getActivity(), "Not yet implemented", 0).show()
        }
    }


}