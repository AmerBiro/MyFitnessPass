package myfitnesspass.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import myfitnesspass.backend.data.local.dao.CoachDao
import myfitnesspass.backend.data.local.entities.Coach
import myfitnesspass.backend.data.local.functions.Converters

@Database(
    entities = [Coach::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CoachDatabase: RoomDatabase() {

    abstract fun noteDao(): CoachDao
}