package my.fitness.myfitness.data.local_database_rrom.database

import androidx.room.Database
import androidx.room.TypeConverters
import com.noteapp.database.collections.Info
import my.fitness.myfitness.data.local_database_rrom.dao.InfoDao

@Database(
    entities = [Info::class],
    version = 1
)

@TypeConverters(Convertors::class)
abstract class InfoDatabase {
    abstract fun infoDao(): InfoDao
}