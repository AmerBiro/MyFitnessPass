package myfitnesspass.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import myfitnesspass.data.local.entities.Program
import kotlinx.coroutines.flow.Flow
import myfitnesspass.data.local.entities.LocallyDeletedProgramID


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
    suspend fun getProgramById(programId: String): Program?

    @Query("SELECT * FROM program ORDER BY creationDate DESC")
    fun getAllPrograms(): Flow<List<Program>>

    @Query("SELECT * FROM program WHERE isSynced = 0")
    suspend fun getAllUnsyncedPrograms(): List<Program>

    @Query("DELETE FROM program WHERE isSynced = 1")
    suspend fun deleteAllSyncedPrograms()

    @Query("SELECT * FROM locally_deleted_program_ids")
    suspend fun getAllLocallyDeletedProgramIDs():List<LocallyDeletedProgramID>

    @Query("Delete from locally_deleted_program_ids WHERE deletedProgramID = :deletedProgramID")
    suspend fun deleteLocallyDeletedProgramID(deletedProgramID: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocallyDeletedProgramID(locallyDeletedProgramID: LocallyDeletedProgramID)

}