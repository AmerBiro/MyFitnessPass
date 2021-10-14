package my.fitness.myfitness.main_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import my.fitness.myfitness.R
import my.fitness.myfitness.main_app.viewPager.*


class Home : Fragment() {


    private val programs = Program()
    private val fitnesss = Fitness()
    private val graphs = Graph()
    private val menuFragments = MenuFragment()
    private val profiles = Profile()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.main_app_home, container, false)

        replaceFragment(programs)

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




        /*
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(myNavigationItemListener);
        bottomNavigationView.setSelectedItemId(R.id.my_menu_item_id);
        * */

        return view
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.viewPager,fragment)
            transaction.commit()
        }
    }



}