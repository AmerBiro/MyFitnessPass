package myfitnesspass.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "program")
data class Program(
    val programName: String,
    val coach: String,
    val description: String,
    val days: Int,
    val creationDate: Long,
    val startDate: Long,
    val endDate: Long,
    @Expose(deserialize = false, serialize = false)
    val isSynced: Boolean = false,

    val fitness: String,
    val lastUpdateDate: Long,
    val parent: String,
    val owner: String,
    val hasAccess: List<String>,
    val imageURL: String,
    val favoriteStatus: Int,

    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()

)