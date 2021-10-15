package my.fitness.myfitness.data.local_database_rrom.database

import androidx.room.Database
import androidx.room.TypeConverters
import com.noteapp.database.collections.Fitness
import my.fitness.myfitness.data.local_database_rrom.dao.FitnessDao

@Database(
    entities = [Fitness::class],
    version = 1
)

@TypeConverters(Convertors::class)
abstract class FitnessDatabase {
    abstract fun fitnessDao(): FitnessDao
}