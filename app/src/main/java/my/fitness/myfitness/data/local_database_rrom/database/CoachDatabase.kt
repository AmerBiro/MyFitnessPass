package my.fitness.myfitness.data.local_database_rrom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.fitness.myfitness.data.local_database_rrom.dao.CoachDao
import my.fitness.myfitness.data.local_database_rrom.entities.Coach
import my.fitness.myfitness.data.local_database_rrom.functions.Converters

@Database(
    entities = [Coach::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CoachDatabase: RoomDatabase() {

    abstract fun noteDao(): CoachDao
}