package myfitnesspass.basic.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import myfitnesspass.fitness.myfitness.R
import myfitnesspass.basic.home.programs.*


class Home : Fragment() {


    private val programs = ProgramView()
    private val fitnesss = FitnessCoachView()
    private val graphs = GraphView()
    private val menuFragments = MenuView()
    private val profiles = ProfileView()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.home, container, false)

        //replaceFragment(programs)

        val bottom = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.program -> replaceFragment(programs)
                R.id.menu -> replaceFragment(menuFragments)
                R.id.graph -> replaceFragment(graphs)
                R.id.fitness -> replaceFragment(fitnesss)
                R.id.profile -> replaceFragment(profiles)
            }
            true
        }

        bottom.selectedItemId =  R.id.program


        return view
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.viewPager,fragment)
            transaction.commit()
        }
    }



}