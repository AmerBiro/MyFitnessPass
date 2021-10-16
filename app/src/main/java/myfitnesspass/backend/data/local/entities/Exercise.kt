package myfitnesspass.backend.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "exercise")
data class Exercise(
     val number: Int,
     val name: String,
     val description: String,
     val set: Int,
     val reps: Int,
     val rest: Double,
     val weight: Double,
     val imageURL: String,
     val videoURL: String,
     val creationDate: Long,
     val lastUpdateDate: Long,
     val hasAccess: List<String>,
     val parent: String,
     val owner: String,
     val favoriteStatus: Int,
     val type:String,
     @Expose(deserialize = false, serialize = false)
     val isSynced: Boolean = false,
     @PrimaryKey(autoGenerate = false)
     val id: String = UUID.randomUUID().toString()
)