package myfitnesspass.repositories

import android.app.Application
import myfitnesspass.data.remote.api.UserApi
import myfitnesspass.other.Resource
import kotlinx.coroutines.flow.Flow
import myfitnesspass.data.local.dao.ProgramDao
import myfitnesspass.data.local.entities.LocallyDeletedProgramID
import myfitnesspass.data.local.entities.Program
import myfitnesspass.data.remote.api.ProgramApi
import myfitnesspass.data.remote.requests.program.DeleteProgramRequest
import myfitnesspass.other.checkForInternetConnection
import myfitnesspass.other.networkBoundResource
import javax.inject.Inject

class ProgramRepository @Inject constructor(
    private val programDao: ProgramDao,
    private val programApi: UserApi,
    private val context: Application
) {
    suspend fun insertProgram(program: Program){
        val response = try {
            programApi.createProgram(program)
        }catch(e: Exception){
            null
        }
        if (response != null && response.isSuccessful){
            programDao.createProgram(program.apply { isSynced = true })
        }else{
            programDao.createProgram(program)
        }
    }


    suspend fun deleteProgram(programId: String){
        val response = try {
            programApi.deleteProgram(DeleteProgramRequest(programId))
        }catch (e:Exception){
            null
        }
        programDao.deleteProgram(programId)
        if (response == null || !response.isSuccessful){
            programDao.insertLocallyDeletedProgramID(LocallyDeletedProgramID(programId))
        }else{
            deleteLocallyDeletedProgramID(programId)
        }
    }


    suspend fun deleteLocallyDeletedProgramID (deletedProgramID: String){
        programDao.deleteLocallyDeletedProgramID(deletedProgramID)
    }



    suspend fun insertPrograms(programs: List<Program>){
        programs.forEach { insertProgram(it) }
    }

    suspend fun getProgramById(programId: String) = programDao.getProgramById(programId)

    fun getAllPrograms(): Flow<Resource<List<Program>>> {
        return networkBoundResource(
            query = {
                programDao.getAllPrograms()
            },
            fetch = {
                programApi.getPrograms()
            },
            saveFetchResult = { response ->
                response.body()?.let {
                    insertPrograms(it)
                }
            },
            shouldFetch = {
                checkForInternetConnection(context)
            }
        )
    }


}