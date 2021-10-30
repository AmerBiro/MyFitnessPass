package myfitnesspass.ui.home.programs.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

class ProgramCreationI : BaseFragment(R.layout.fragment_program_creation_i) {
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

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }

/*
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            myCalendar.set(Calendar.YEAR,i)
            myCalendar.set(Calendar.MONTH,i2)
            myCalendar.set(Calendar.DAY_OF_MONTH,i3)
            updateLabel(myCalendar)
        }


        binding.selectDate.setOnClickListener{
            DatePickerDialog(requireContext(),datePicker,myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH))
                .show()
        }



     /*   binding.radioGroup.setOnCheckedChangeListener{radioGroup, i ->
            if (i == R.id.radio_one){
                binding.selectDate.setOnClickListener{
                    showDateRangePicker()
                }
            }
            if (i == R.id.radio_two){
                binding.selectDate.setOnClickListener{
                    DatePickerDialog(requireContext(),datePicker,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH))
                        .show()
                }
            }
        }

      */

 */


        return view
    }

    /*
    private fun updateLabel(myCalendar: Calendar) {
        val myFormat  ="dd-MM-yyyy"
        val sdf  =SimpleDateFormat(myFormat,Locale.getDefault())
        binding.selectDate.text = sdf.format(myCalendar.time)

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

     */

}