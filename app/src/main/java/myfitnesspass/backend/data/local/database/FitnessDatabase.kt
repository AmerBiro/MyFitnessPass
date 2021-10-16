package myfitnesspass.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import myfitnesspass.backend.data.local.dao.FitnessDao
import myfitnesspass.backend.data.local.entities.Fitness
import myfitnesspass.backend.data.local.functions.Converters

@Database(
    entities = [Fitness::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class FitnessDatabase : RoomDatabase() {
    abstract fun fitnessDao(): FitnessDao
}