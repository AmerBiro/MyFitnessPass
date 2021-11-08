package myfitnesspass.ui.home.programs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myfitnesspass.adapters.recycler_view.ProgramAdapter
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentProgramShowBinding
import myfitnesspass.ui.BaseFragment

class ShowProgramsFragment: BaseFragment(R.layout.fragment_program_show), ProgramAdapter.OnItemClickListener {

    private var _binding: FragmentProgramShowBinding? = null
    private val binding get() = _binding!!

    private var layoutManger: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>?  =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgramShowBinding.inflate(inflater, container, false)
        val view = binding.root

        layoutManger = LinearLayoutManager(requireContext())

        binding.recyclerview.layoutManager = layoutManger

        adapter  =ProgramAdapter(requireContext(),this)
        binding.recyclerview.adapter = adapter


        binding.addProgram.setOnClickListener {
              findNavController().navigate(R.id.action_homeView_to_programCreationI)

        }



        return view
    }



    override fun onItemClick(position: Int) {
       Toast.makeText(requireContext(),"item $position clicked",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_homeView_to_programView)
        //findNavController().popBackStack()
    }
}