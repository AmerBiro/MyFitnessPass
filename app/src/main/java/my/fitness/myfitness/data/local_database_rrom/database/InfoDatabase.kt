package my.fitness.myfitness.data.local_database_rrom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.fitness.myfitness.data.local_database_rrom.entities.Info
import my.fitness.myfitness.data.local_database_rrom.functions.Converters

@Database(
    entities = [Info::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class InfoDatabase : RoomDatabase(){
//    abstract fun infoDao(): InfoDao
}