package my.fitness.myfitness.data.local_database_rrom.database

import androidx.room.Database
import androidx.room.TypeConverters
import com.noteapp.database.collections.Program
import my.fitness.myfitness.data.local_database_rrom.dao.ProgramDao

@Database(
    entities = [Program::class],
    version = 1
)

@TypeConverters(Convertors::class)
abstract class ProgramDatabase {
    abstract fun programDao(): ProgramDao
}