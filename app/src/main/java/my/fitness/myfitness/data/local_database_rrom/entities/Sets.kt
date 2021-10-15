package my.fitness.myfitness.data.local_database_rrom.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "sets")
data class Sets(
    val number: Int,
    val weight: Double,
    val creationDate: Long,
    val lastUpdateDate: Long,
    val parent: String,
    val owner: String,
    @Expose(deserialize = false, serialize = false)
    val isSynced: Boolean = false,
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()
)