package my.fitness.myfitness.database.local_database_rrom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noteapp.database.collections.Info
import kotlinx.coroutines.flow.Flow

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createInfo(info: Info)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInfo(info: Info)

    @Query("SELECT * FROM info WHERE id = :infoId")
    fun observeInfoById(infoId: String): LiveData<Info>

    @Query("SELECT * FROM info WHERE id = :infoId")
    suspend fun getInfoIdById(infoId: String)

    @Query("SELECT * FROM info WHERE isSynced = 0")
    suspend fun getUnsyncedInfo(): List<Info>

}