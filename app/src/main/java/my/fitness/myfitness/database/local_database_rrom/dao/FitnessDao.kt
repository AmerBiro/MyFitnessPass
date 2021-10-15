package my.fitness.myfitness.database.local_database_rrom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noteapp.database.collections.Fitness
import kotlinx.coroutines.flow.Flow

@Dao
interface FitnessDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createFitness(fitness: Fitness)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFitness(fitness: Fitness)

    @Query("DELETE FROM fitness WHERE id = :fitnessId")
    suspend fun deleteFitness(fitnessId: String)

    @Query("SELECT * FROM fitness WHERE id = :fitnessId")
    fun observeFitnessById(fitnessId: String): LiveData<Fitness>

    @Query("SELECT * FROM fitness WHERE id = :fitnessId")
    suspend fun getFitnessIdById(fitnessId: String)

    @Query("SELECT * FROM fitness ORDER BY creationDate DESC")
    fun getAllCoaches(): Flow<List<Fitness>>

    @Query("SELECT * FROM fitness WHERE isSynced = 0")
    suspend fun getAllUnsyncedFitness(): List<Fitness>

    @Query("DELETE FROM fitness WHERE isSynced = 1")
    suspend fun deleteAllSyncedFitness()
}