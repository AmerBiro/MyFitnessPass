package myfitnesspass.ui.home.programs.fragments

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIBinding
import myfitnesspass.ui.BaseFragment
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class ProgramCreationII : BaseFragment(R.layout.fragment_program_creation_i_i) {

    val args: ProgramCreationIIArgs by navArgs()

    private var startDate: String = ""

    private var _binding: FragmentProgramCreationIIBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myCalendar = Calendar.getInstance()

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }
    }

    override fun onStart() {
        super.onStart()

        binding.buttonNextArrow.setOnClickListener {
//            Log.d(TAG, "onStart: $programName , $programDes, $date")
            val action = ProgramCreationIIDirections.actionProgramCreationIIToProgramCreationIII(
                args.programName,
                args.programDiscription,
                startDate
            )
            findNavController().navigate(action)
        }

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault()).format(myCalendar.time)
        startDate = sdf.toString()
    }


}