package myfitnesspass.ui.home.programs.fragments

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import myfitnesspass.data.local.entities.Program
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIBinding
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramCreationIIIIIBinding
import myfitnesspass.other.Constants.KEY_LOGGED_IN_EMAIL
import myfitnesspass.other.Constants.NO_KEY_LOGGED_IN_EMAIL
import myfitnesspass.ui.BaseFragment
import myfitnesspass.ui.auth.login.viewmodel.LoginViewModel
import myfitnesspass.ui.home.programs.viewmodel.CreateProgramViewModel
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class ProgramCreationIIIII : BaseFragment(R.layout.fragment_program_creation_i_i_i_i_i) {

    private var _binding: FragmentProgramCreationIIIIIBinding? = null
    private val binding get() = _binding!!

    val args: ProgramCreationIIIIIArgs by navArgs()
    private val viewModel: CreateProgramViewModel by viewModels()

    @Inject
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramCreationIIIIIBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d(TAG, "onViewCreated: ${args.programName}, ${args.programDes}, ${args.startDate}, ${args.endDate}, ${args.item}")
    }

    override fun onStart() {
        super.onStart()

        binding.buttonDone.setOnClickListener {
            saveProgram()
            findNavController().navigate(R.id.action_programCreationIIIII_to_homeView)
        }

        binding.buttonBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun saveProgram(){

        val authEmail = sharedPref.getString(KEY_LOGGED_IN_EMAIL, NO_KEY_LOGGED_IN_EMAIL) ?: NO_KEY_LOGGED_IN_EMAIL
        val programName = args.programName
        val programDes = args.programDes
        val startDate = args.startDate
        val endDate = args.endDate
        val item = args.item
        val coachName = binding.coachName.text.toString()
        val fitnessName = binding.fitnessName.text.toString()
        val creationDate = System.currentTimeMillis()
        val id = UUID.randomUUID().toString()
        val owners = listOf(authEmail)

        val program = Program(programName, coachName, programDes
                    , 0, creationDate, 0, 0,
        false, fitnessName, 0, "",
            authEmail, owners, "", 0, id)

        viewModel.createProgram(program)

    }

}