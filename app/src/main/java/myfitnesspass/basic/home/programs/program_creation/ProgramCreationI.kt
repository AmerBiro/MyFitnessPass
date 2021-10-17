package myfitnesspass.basic.home.programs.program_creation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramViewBinding
import java.text.SimpleDateFormat
import java.util.*

class ProgramCreationI : Fragment() {
    private var _binding: FragmentProgramCreationIBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.buttonNextArrow.setOnClickListener {
            findNavController().navigate(R.id.action_programCreationI_to_programCreationII)

        }



        binding.selectDate.setOnClickListener{
            showDateRangePicker()
        }



        return view
    }



    private fun showDateRangePicker(){
        val dateRangePicker = MaterialDatePicker.Builder
            .dateRangePicker()
            .setTitleText("Select Date")
            .build()

        dateRangePicker.show(
            childFragmentManager,"date_range_picker"
        )

        dateRangePicker.addOnPositiveButtonClickListener { dataPicked ->

        val startDate = dataPicked.first
        val endDate = dataPicked.second
            if (startDate != null && endDate != null){
                binding.selectDate.text = convertLongToDate(startDate)+" "+ convertLongToDate(endDate)
            }


        }

    }

    private fun convertLongToDate(time:Long):String{
        val date = Date(time)
        val format = SimpleDateFormat(
            "dd-MM-yyyy", Locale.getDefault()
        )

        return format.format(date)

    }

}