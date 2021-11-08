package myfitnesspass.ui.home.programs.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
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
import java.util.jar.Manifest

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

        binding.addDay.setOnClickListener {
            findNavController().navigate(R.id.action_programView_to_dayCreationI)
        }


        binding.buttonClose.setOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.programImageButton.setOnClickListener {
           // requireActivity().onBackPressed()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (requireActivity().checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    val permissionss = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                   requestPermissions(permissionss, PERMISSION_CODE)

                }else{
                    pickImageFromGallery()

                }
            }else{
                pickImageFromGallery()
            }
        }

        layoutManger = LinearLayoutManager(requireContext())
        binding.recyclerviewDays.layoutManager = layoutManger
        adapter  =DayAdapter(this)
        binding.recyclerviewDays.adapter = adapter

        //to show how many items we have in the recycler view "the numbers of days"
        binding.daysText.text = binding.recyclerviewDays.adapter?.itemCount.toString()


        return view
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(),"item $position clicked", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_programView_to_showExercisesFragment)
        //findNavController().popBackStack()
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1000
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery()
                }
                else{
                    Toast.makeText(requireContext(),"Permission denied",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            binding.programImageButton.setImageURI(data?.data)
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

}