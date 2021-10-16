package my.fitness.myfitness.backend.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.fitness.myfitness.backend.data.local.dao.InfoDao
import my.fitness.myfitness.backend.data.local.entities.Info
import my.fitness.myfitness.backend.data.local.functions.Converters

@Database(
    entities = [Info::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class InfoDatabase : RoomDatabase(){
    abstract fun infoDao(): InfoDao
}