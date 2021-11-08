package myfitnesspass.ui.subhome.exercises.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myfitnesspass.adapters.recycler_view.ExerciseAdapter
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentShowExercisesBinding
import myfitnesspass.ui.BaseFragment

class ShowExercisesFragment : BaseFragment(R.layout.fragment_show_exercises),ExerciseAdapter.OnItemClickListener {

    private var _binding: FragmentShowExercisesBinding? = null
    private val binding get() = _binding!!

    private var layoutManger: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>?  =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowExercisesBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.addExercise.setOnClickListener {
            findNavController().navigate(R.id.action_showExercisesFragment_to_exerciseCreationI)

        }

        layoutManger = LinearLayoutManager(requireContext())
        binding.recyclerviewExercises.layoutManager = layoutManger
        adapter  =ExerciseAdapter(requireContext(),this)
        binding.recyclerviewExercises.adapter = adapter




        return view
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(),"item $position clicked", Toast.LENGTH_SHORT).show()
    }


}