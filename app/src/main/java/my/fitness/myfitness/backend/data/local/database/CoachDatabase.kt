package my.fitness.myfitness.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.fitness.myfitness.backend.data.local.dao.CoachDao
import my.fitness.myfitness.backend.data.local.entities.Coach
import my.fitness.myfitness.backend.data.local.functions.Converters

@Database(
    entities = [Coach::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CoachDatabase: RoomDatabase() {

    abstract fun noteDao(): CoachDao
}