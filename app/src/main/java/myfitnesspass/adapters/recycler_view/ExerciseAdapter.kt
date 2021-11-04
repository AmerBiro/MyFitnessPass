package myfitnesspass.adapters.recycler_view

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.exercises_list_view.view.*
import myfitnesspass.fitness.myfitness.R

class ExerciseAdapter(val c: Context,
                      val listener: OnItemClickListener
                      ): RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {


    private var exerciseName = arrayOf("ABS AND ARMS","Lower-Body Strength", "Hit + ABS AND ARMS")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExerciseAdapter.ExerciseViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.exercises_list_view,parent,false)
       return ExerciseViewHolder(v)
    }



    override fun getItemCount(): Int {
        return exerciseName.size
    }

    override fun onBindViewHolder(holder: ExerciseAdapter.ExerciseViewHolder, position: Int) {

        holder.exerciseNameTextView.text = exerciseName[position]

        holder.moreButton.setOnClickListener {
            popupMenu(it)
        }

    }



    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        val exerciseNameTextView :TextView = itemView.exercise_name
        val moreButton: Button = itemView.more_button


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

