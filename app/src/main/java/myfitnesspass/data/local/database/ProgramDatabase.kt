package myfitnesspass.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import myfitnesspass.data.local.dao.ProgramDao
import myfitnesspass.data.local.entities.LocallyDeletedProgramID
import myfitnesspass.data.local.entities.Program
import myfitnesspass.data.local.others.Converters

@Database(
    entities = [Program::class,LocallyDeletedProgramID::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ProgramDatabase : RoomDatabase() {

    abstract fun programDao(): ProgramDao
}