package myfitnesspass.adapters.recycler_view

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import myfitnesspass.data.local.entities.Program
import myfitnesspass.fitness.myfitness.R
import kotlinx.android.synthetic.main.program_list_view.view.*

//https://www.youtube.com/watch?v=k_UZkS_L61Y kotlin android how to add in recyclerview popup menu
class ProgramAdapter(val c:Context,
                     val listener : OnItemClickListener
) :
    RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>() {


    private val diffCallback = object : DiffUtil.ItemCallback<Program>() {
        override fun areItemsTheSame(oldItem: Program, newItem: Program): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Program, newItem: Program): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }


    private val differ = AsyncListDiffer(this, diffCallback)

    var programs: List<Program>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    //test
    private var programName = arrayOf("Crossfit Madmen","Peaks and Valleys")
    private var coachName = arrayOf("By Thomas Andersen","By Sulaiman Kasas")
    private var programDescription = arrayOf("This course has been designed\n for fat burning and muscles gowing","This course has been designed\n for fat burning and muscles gowing")
    private var programdays = arrayOf("3 days","2 days")
    private var programdate = arrayOf("12/10/2021 12/11/2021","12/01/2022 12/02/2022")




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
                R.layout.program_list_view,
                parent,
                false
            )
        return ProgramViewHolder(v)
    }

    override fun getItemCount(): Int {
       // return programs.size
        return programName.size
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.programName.text =programName[position]
        holder.programDescription.text =programDescription[position]
        holder.programCoach.text =coachName[position]
        holder.programDays.text =programdays[position]
        holder.programDate.text =programdate[position]



       /*     program_name.text = programName[position]
        program_coach.text = coachName[position]
        program_description.text = programDescription[position]
        program_days.text = programdays[position]
//            program_exercises.text = program
        program_date.text = programdate[position]


        menu_buttons.setOnClickListener {
            popupMenu(it)
        }

        */



      /*
        val program = programs[position]
        holder.itemView.apply {
            program_name.text = program.programName
            program_coach.text = program.coach
            program_description.text = program.description
            program_days.text = program.days.toString()
//            program_exercises.text = program
            program_date.text = "$program.startDate.toString() - ${program.endDate.toString()}"
        }

       */
    }


    inner class ProgramViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        val programName: TextView = itemView.program_name
        val programDescription: TextView = itemView.program_description
        val programDays: TextView = itemView.program_days
        val programDate: TextView = itemView.program_date
        val programCoach: TextView = itemView.program_coach

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position!= RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }

        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


    private fun popupMenu(v:View){
        val popupMenus = PopupMenu(c.applicationContext,v)
        popupMenus.inflate(R.menu.program_item_more)
        popupMenus.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.edit -> {
                    true
                }

                R.id.delete ->{
                    true
                }

                else -> true

            }
        }
        popupMenus.show()
        popupMenus.gravity = Gravity.LEFT
        val popup = PopupMenu::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val menu = popup.get(popupMenus)
        menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
            .invoke(menu,true)
    }


}
