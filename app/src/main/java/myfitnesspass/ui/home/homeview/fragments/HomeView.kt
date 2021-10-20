package myfitnesspass.ui.home.homeview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.fitness.myfitness.databinding.HomeBinding
import myfitnesspass.ui.BaseFragment
import myfitnesspass.ui.home.coach_fitness.viewpager.fragments.ViewFitnessCoach
import myfitnesspass.ui.home.graph.fragments.GraphFragment
import myfitnesspass.ui.home.menu.fragments.MenuView
import myfitnesspass.ui.home.programs.fragments.ShowProgramsFragment
import myfitnesspass.ui.profile.fragments.ProfileFragment

//class HomeView: BaseFragment(R.layout.home) {
class HomeView: BaseFragment(R.layout.home) {
    private val programView = ShowProgramsFragment()
    private val fitnessCoachView = ViewFitnessCoach()
    private val graphsView = GraphFragment()
    private val menuView = MenuView()
    private val profileView = ProfileFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.home, container, false)

        val bottom = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom.setOnNavigationItemSelectedListener  {
            when(it.itemId){
                R.id.program -> replaceFragment(programView)
                R.id.menu -> replaceFragment(menuView)
                R.id.graph -> replaceFragment(graphsView)
                R.id.fitness -> replaceFragment(fitnessCoachView)
                R.id.profile -> replaceFragment(profileView)
            }
            true
        }

        bottom.selectedItemId =  R.id.program

        return view

    }

    override fun onStart() {
        super.onStart()




    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.viewPager,fragment)
            transaction.commit()
        }
    }
}