package my.fitness.myfitness.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.fitness.myfitness.backend.data.local.dao.ProgramDao
import my.fitness.myfitness.backend.data.local.entities.Program
import my.fitness.myfitness.backend.data.local.functions.Converters


@Database(
    entities = [Program::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class ProgramDatabase : RoomDatabase() {

    abstract fun programDao(): ProgramDao
}