package my.fitness.myfitness.data.local_database_rrom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.fitness.myfitness.data.local_database_rrom.entities.Program
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createProgram(program: Program)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProgram(program: Program)

    @Query("DELETE FROM program WHERE id = :programId")
    suspend fun deleteProgram(programId: String)

    @Query("SELECT * FROM program WHERE id = :programId")
    fun observeProgramById(programId: String): LiveData<Program>

    @Query("SELECT * FROM program WHERE id = :programId")
    suspend fun getProgramById(programId: String)

    @Query("SELECT * FROM program ORDER BY creationDate DESC")
    fun getAllPrograms(): Flow<List<Program>>

    @Query("SELECT * FROM program WHERE isSynced = 0")
    suspend fun getAllUnsyncedPrograms(): List<Program>

    @Query("DELETE FROM program WHERE isSynced = 1")
    suspend fun deleteAllSyncedPrograms()

}