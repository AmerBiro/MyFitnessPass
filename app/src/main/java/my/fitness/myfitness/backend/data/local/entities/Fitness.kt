package my.fitness.myfitness.backend.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "fitness")
data class Fitness(
    val fitnessName: String,
    val membershipId: String,
    val memberSince: Long,
    val phoneNumber: Int,
    val email: String,
    val website: String,
    val creationDate: Long,
    val lastUpdateDate: Long,
    val parent: String,
    val owner: String,
    @Expose(deserialize = false, serialize = false)
    val isSynced: Boolean = false,
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()
)