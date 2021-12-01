package myfitnesspass.ui.home.programs.fragments

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_program_show.*
import myfitnesspass.adapters.recycler_view.ProgramAdapter
import myfitnesspass.adapters.recycler_view.ProgramsAD
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramShowBinding
import myfitnesspass.other.Status
import myfitnesspass.ui.BaseFragment
import myfitnesspass.ui.home.homeview.fragments.HomeViewDirections
import myfitnesspass.ui.home.programs.viewmodel.ShowProgramsViewModel

@AndroidEntryPoint
class ShowProgramsFragment: BaseFragment(R.layout.fragment_program_show) {

    private val viewModel: ShowProgramsViewModel by viewModels()

    private var _binding: FragmentProgramShowBinding? = null
    private val binding get() = _binding!!

    private lateinit var programAdapter: ProgramsAD
    private lateinit var view2: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramShowBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view2 = view
        requireActivity().requestedOrientation = SCREEN_ORIENTATION_USER
        setupRecyclerView()
        subscribeToObservers()
        onItemClickListener()

        binding.addProgram.setOnClickListener{
            findNavController().navigate(R.id.action_homeView_to_programCreationI)
        }
    }

    private fun setupRecyclerView() = binding.recyclerview.apply {
        programAdapter = ProgramsAD()
        adapter = programAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun onItemClickListener() {
        programAdapter.setOnItemClickListener{
            findNavController().navigate(
                HomeViewDirections.actionHomeViewToProgramView(it.id)
            )
        }
    }

//    private fun subscribeToObservers() {
//        viewModel.allPrograms.observe(viewLifecycleOwner, Observer {
//            it?.let{event ->
//                val result = event.peekContent()
//                when (result.status){
//
//                    Status.SUCCESS -> {
//                        programAdapter.programs = result.data!!
//                        binding.swipeRefreshLayout.isRefreshing = false
//                    }
//
//                    Status.LOADING -> {
//                        result.data?.let { programs ->
//                            programAdapter.programs = programs
//                        }
//                        binding.swipeRefreshLayout.isRefreshing = true
//                    }
//
//                    Status.ERROR -> {
//                        event.getContentIfNotHandled()?.let { errorResource ->
//                            errorResource.message?.let { message ->
//                                showSnackBar(view2, message)
//                            }
//                        }
//                        result.data?.let { programs ->
//                            programAdapter.programs = programs
//                        }
//                        binding.swipeRefreshLayout.isRefreshing = false
//                    }
//
//                }
//            }
//        })
//    }


    private fun subscribeToObservers() {
        viewModel.allPrograms.observe(viewLifecycleOwner, Observer {
            it?.let { event ->
                val result = event.peekContent()
                when(result.status) {
                    Status.SUCCESS -> {
                        programAdapter.programs = result.data!!
                        swipeRefreshLayout.isRefreshing = false
                    }
                    Status.ERROR -> {
                        event.getContentIfNotHandled()?.let { errorResource ->
                            errorResource.message?.let { message ->
                                showSnackBar(view2, message)
                            }
                        }
                        result.data?.let { programs ->
                            programAdapter.programs = programs
                        }
                        swipeRefreshLayout.isRefreshing = false
                    }
                    Status.LOADING -> {
                        result.data?.let { programs ->
                            programAdapter.programs = programs
                        }
                        swipeRefreshLayout.isRefreshing = true
                    }
                }
            }
        })
    }

}