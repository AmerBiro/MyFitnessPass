package my.fitness.myfitness.data.local_database_rrom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.fitness.myfitness.data.local_database_rrom.dao.ProgramDao
import my.fitness.myfitness.data.local_database_rrom.entities.Program
import my.fitness.myfitness.data.local_database_rrom.functions.Converters


@Database(
    entities = [Program::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class ProgramDatabase : RoomDatabase() {

    abstract fun programDao(): ProgramDao
}