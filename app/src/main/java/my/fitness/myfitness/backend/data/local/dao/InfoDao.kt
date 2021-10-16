package my.fitness.myfitness.backend.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.fitness.myfitness.backend.data.local.entities.Info

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