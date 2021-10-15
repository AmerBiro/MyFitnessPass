package my.fitness.myfitness.database.local_database_rrom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noteapp.database.collections.Program
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


//    suspend fun isProgramOwner(programId: String, owner: String): Boolean{
//        val program = programs.findOneById(programId) ?: return false
//        return program.owner == owner
//    }
//
//    suspend fun isProgramAlreadyShared(programId: String, email: String): Boolean{
//        val program = programs.findOneById(programId)?: return true
//        return email in program.hasAccess
//    }
//
//    suspend fun shareProgramWithOthers(programId: String, email: String): Boolean {
//        val hasAccess = programs.findOneById(programId)?.hasAccess ?: return false
//        return programs.updateOneById(programId, setValue(Program::hasAccess, hasAccess + email)).wasAcknowledged()
//    }
//
//    suspend fun getProgramsSharedWIthMe(email: String): List<Program> {
//        return programs.find(Program::hasAccess contains email).toList()
//    }
//
//    suspend fun removeProgramFromSharedWithMeList(programId: String, email: String): Boolean {
//        val program = programs.findOne(Program::id eq programId, Program::hasAccess contains email)
//        program?.let { program ->
//            val newHasAccess = program.hasAccess - email
//            val updateResult = programs.updateOne(Program::id eq program.id, setValue(Program::hasAccess, newHasAccess))
//            return updateResult.wasAcknowledged()
//        } ?: return false
//    }
//
//    suspend fun getFavoritePrograms(parent: String): List<Program> {
//        return programs.find(Program::parent eq parent, Program::favoriteStatus eq 1).toList()
//    }
//
//    suspend fun addProgramToFavorite(programId: String): Boolean {
//        val program = programs.findOne(Program::id eq programId, Program::favoriteStatus ne 1)
//        program?.let { program ->
//            val newFavoriteStatus = 1
//            val updateResult = programs.updateOne(Program::id eq program.id, setValue(Program::favoriteStatus, newFavoriteStatus))
//            return updateResult.wasAcknowledged()
//        } ?: return false
//    }
//
//    suspend fun removeProgramFromFavorite(programId: String): Boolean {
//        val program = programs.findOne(Program::id eq programId, Program::favoriteStatus ne 0)
//        program?.let { program ->
//            val newFavoriteStatus = 0
//            val updateResult = programs.updateOne(Program::id eq program.id, setValue(Program::favoriteStatus, newFavoriteStatus))
//            return updateResult.wasAcknowledged()
//        } ?: return false
//    }


}