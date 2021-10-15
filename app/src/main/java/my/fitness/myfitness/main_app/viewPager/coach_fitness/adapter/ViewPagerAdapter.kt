package my.fitness.myfitness.main_app.viewPager.coach_fitness.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import my.fitness.myfitness.main_app.viewPager.coach_fitness.CoachView
import my.fitness.myfitness.main_app.viewPager.coach_fitness.FitnessView

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {

        return 2

    }

    override fun createFragment(position: Int): Fragment {

     return when (position){

            0-> {
                FitnessView()

            }
            1-> {
                CoachView()
            }
         else -> {
             Fragment()
         }
        }
    }


}