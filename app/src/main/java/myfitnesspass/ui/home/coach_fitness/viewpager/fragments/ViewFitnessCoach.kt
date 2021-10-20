package myfitnesspass.ui.home.coach_fitness.viewpager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.FragmentFitnessCoachViewBinding
import myfitnesspass.ui.BaseFragment
import myfitnesspass.ui.home.coach_fitness.adapters.ViewPagerAdapter

class ViewFitnessCoach :BaseFragment(R.layout.fragment_fitness_coach_view){


    private var _binding: FragmentFitnessCoachViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

