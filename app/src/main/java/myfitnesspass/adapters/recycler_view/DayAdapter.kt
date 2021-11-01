package myfitnesspass.adapters.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.day_list_view.view.*
import myfitnesspass.fitness.myfitness.R

class DayAdapter (val listener: OnItemClickListener): RecyclerView.Adapter<DayAdapter.DayViewHolder>(){




    private var dayName = arrayOf("underkropp","overkropp")
    private var dayNumber = arrayOf("1","2")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.day_list_view,parent,false)
        return DayViewHolder(v)
    }


    override fun getItemCount(): Int {
       return dayName.size
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.dayName.text = dayName[position]
        holder.dayNumber.text = "day " + dayNumber[position]



    }


    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        val dayName : TextView = itemView.day_name
        val dayNumber: TextView = itemView.day_number


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



}