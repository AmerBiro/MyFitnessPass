package myfitnesspass.ui.home.programs.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIBinding
import myfitnesspass.ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.*


class ProgramCreationIII : BaseFragment(R.layout.fragment_program_creation_i_i_i) {

    private var _binding: FragmentProgramCreationIIIBinding? = null
    private val binding get() = _binding!!

    val args: ProgramCreationIIIArgs by navArgs()

    private var endDate: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIIBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var programName = args.programName
//        var programDes = args.programDes
//        var startDate = args.startDate
//        Log.d(TAG, "onViewCreated: $programName, $programDes, $startDate")

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
            val action = ProgramCreationIIIDirections.actionProgramCreationIIIToProgramCreationIIII(
                args.programName, args.programDes, args.startDate, endDate
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
        endDate = sdf.toString()
    }


}