package myfitnesspass.ui.home.programs.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIBinding
import myfitnesspass.ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.*


class ProgramCreationIII : BaseFragment(R.layout.fragment_program_creation_i_i_i){

    private var _binding: FragmentProgramCreationIIIBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramCreationIIIBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonNextArrow.setOnClickListener {
            findNavController().navigate(R.id.action_programCreationIII_to_programCreationIIII)

        }


        val myCalendar = Calendar.getInstance()

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLabel(myCalendar)
        }




        return view
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat  ="dd-MM-yyyy"
        val sdf  = SimpleDateFormat(myFormat,Locale.getDefault())
        binding.showDate.text = sdf.format(myCalendar.time)

    }


}