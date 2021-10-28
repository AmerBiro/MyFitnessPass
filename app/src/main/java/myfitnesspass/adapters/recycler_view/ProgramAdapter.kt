package myfitnesspass.adapters.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import myfitnesspass.data.local.entities.Program
import myfitnesspass.fitness.myfitness.R
import kotlinx.android.synthetic.main.program_list_view.view.*


class ProgramAdapter : RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>() {

    inner class ProgramViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        return ProgramViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.program_list_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return programs.size
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val program = programs[position]
        holder.itemView.apply {
            program_name.text = program.programName
            program_coach.text = program.coach
            program_description.text = program.description
            program_days.text = program.days.toString()
//            program_exercises.text = program
            program_date.text = "$program.startDate.toString() - ${program.endDate.toString()}"
        }
    }


}
