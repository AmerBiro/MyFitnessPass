package myfitnesspass.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import myfitnesspass.backend.data.local.dao.ProgramDao
import myfitnesspass.backend.data.local.entities.Program
import myfitnesspass.backend.data.local.functions.Converters


@Database(
    entities = [Program::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class ProgramDatabase : RoomDatabase() {

    abstract fun programDao(): ProgramDao
}