package myfitnesspass.adapters.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.program_list_view.view.*
import myfitnesspass.data.local.entities.Program
import myfitnesspass.fitness.myfitness.R
import java.text.SimpleDateFormat
import java.util.*

class ProgramsAD : RecyclerView.Adapter<ProgramsAD.ProgramsViewHolder>() {

    private var onItemClickListener: ((Program) -> Unit)? = null
    private var onItemMenuClickListener: ((Program) -> Unit)? = null
    private var onItemFavoriteClickListener: ((Program) -> Unit)? = null
    private var onItemShareClickListener: ((Program) -> Unit)? = null

    inner class ProgramsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramsViewHolder {
        return ProgramsViewHolder(
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

    override fun onBindViewHolder(holder: ProgramsViewHolder, position: Int) {
        val program = programs[position]
        holder.itemView.apply {
            program_name.text = program.programName
            program_coach.text = program.coach
            program_description.text = program.description
            program_days.text = program.days.toString()
//            program_exercises.text = program.exercises
            program_date.text = "${program.startDate} - ${program.endDate}"

            if (!program.isSynced) {
                isProgramSynced.setImageResource(R.drawable.ic_baseline_cloud_off_24)
            } else {
                isProgramSynced.setImageResource(R.drawable.ic_baseline_cloud_on_24)
            }

            val dateFormat = SimpleDateFormat("dd.MM.yy, HH:mm", Locale.getDefault())
            val dateString = dateFormat.format(program.creationDate)
            program_creation_date.text = dateString

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(program)
                }
            }

            menu_buttons.setOnClickListener {
                onItemMenuClickListener?.let { click ->
                    click(program)
                }
            }

            favorite_button.setOnClickListener {
                onItemFavoriteClickListener?.let { click ->
                    click(program)
                }
            }

            share_button.setOnClickListener {
                onItemShareClickListener?.let { click ->
                    click(program)
                }
            }

        }
    }

    fun setOnItemClickListener(onItemClick: (Program) -> Unit) {
        this.onItemClickListener = onItemClick
    }

    fun setOnItemMenuClickListener(onItemMenuClick: (Program) -> Unit) {
        this.onItemMenuClickListener = onItemMenuClick
    }

    fun setOnItemFavoriteClickListener(onItemFavoriteClick: (Program) -> Unit) {
        this.onItemFavoriteClickListener = onItemFavoriteClick
    }

    fun setOnItemShareClickListener(onItemShareClick: (Program) -> Unit) {
        this.onItemShareClickListener = onItemShareClick
    }

}