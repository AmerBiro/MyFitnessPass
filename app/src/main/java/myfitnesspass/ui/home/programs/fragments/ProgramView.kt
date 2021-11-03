package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myfitnesspass.adapters.recycler_view.DayAdapter
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramViewBinding
import myfitnesspass.ui.BaseFragment

class ProgramView : BaseFragment(R.layout.fragment_program_view), DayAdapter.OnItemClickListener {

    private var _binding: FragmentProgramViewBinding? = null
    private val binding get() = _binding!!
    private var layoutManger: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<DayAdapter.DayViewHolder>?  =null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProgramViewBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_programView_to_dayCreationI)
        }

        binding.programImageButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        layoutManger = LinearLayoutManager(requireContext())
        binding.recyclerviewDays.layoutManager = layoutManger
        adapter  =DayAdapter(this)
        binding.recyclerviewDays.adapter = adapter

        binding.daysText.text = binding.recyclerviewDays.adapter?.itemCount.toString()








        return view
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(),"item $position clicked", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_programView_to_showExercisesFragment)
        //findNavController().popBackStack()
    }

}