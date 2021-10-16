package myfitnesspass.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import myfitnesspass.backend.data.local.dao.InfoDao
import myfitnesspass.backend.data.local.entities.Info
import myfitnesspass.backend.data.local.functions.Converters

@Database(
    entities = [Info::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class InfoDatabase : RoomDatabase(){
    abstract fun infoDao(): InfoDao
}