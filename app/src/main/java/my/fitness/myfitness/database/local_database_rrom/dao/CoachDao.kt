package my.fitness.myfitness.database.local_database_rrom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noteapp.database.collections.Coach
import kotlinx.coroutines.flow.Flow

@Dao
interface CoachDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCoach(coach: Coach)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCoach(coach: Coach)

    @Query("DELETE FROM coach WHERE id = :coachId")
    suspend fun deleteCoaches(coachId: String)

    @Query("SELECT * FROM coach WHERE id = :coachId")
    fun observeProgramById(coachId: String): LiveData<Coach>

    @Query("SELECT * FROM coach WHERE id = :coachIdId")
    suspend fun getCoachIdById(coachIdId: String)

    @Query("SELECT * FROM coach ORDER BY creationDate DESC")
    fun getAllCoaches(): Flow<List<Coach>>

    @Query("SELECT * FROM coach WHERE isSynced = 0")
    suspend fun getAllUnsyncedCoaches(): List<Coach>

    @Query("DELETE FROM coach WHERE isSynced = 1")
    suspend fun deleteAllSyncedCoaches()

}