package my.fitness.myfitness.ui.home.programs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import my.fitness.myfitness.R
import my.fitness.myfitness.adapters.ViewPagerAdapter
import my.fitness.myfitness.databinding.FragmentFitnessCoachViewBinding
import my.fitness.myfitness.databinding.FragmentProgramViewBinding

class FitnessCoachView : Fragment() {

    private var _binding: FragmentFitnessCoachViewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFitnessCoachViewBinding.inflate(inflater, container, false)
        val view = binding.root

        val tabLayout = binding.tabsId
        val viewPager = binding.viewPager2
        val adapter = ViewPagerAdapter(childFragmentManager,lifecycle)

        viewPager.adapter = adapter

        //Fragment no longer exists for key FragmentStateAdapter with Viewpager2
        viewPager.isSaveEnabled = false

        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            when(position){
                0->{
                    tab.setIcon(R.drawable.ic_fitness)
                }
                1->{
                    tab.setIcon(R.drawable.ic_coach)
                }
            }


        }.attach()

        return view
    }
}