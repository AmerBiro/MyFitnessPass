package myfitnesspass.repositories

import android.app.Application
import myfitnesspass.data.remote.api.UserApi
import myfitnesspass.data.remote.requests.user.UserRequest
import myfitnesspass.other.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import myfitnesspass.data.local.dao.ProgramDao
import myfitnesspass.data.local.entities.Program
import myfitnesspass.data.remote.api.ProgramApi
import myfitnesspass.other.checkForInternetConnection
import myfitnesspass.other.networkBoundResource
import javax.inject.Inject

class ProgramRepository @Inject constructor(
    private val programDao: ProgramDao,
    private val userApi: UserApi,
    private val context: Application
) {
    suspend fun insertProgram(program: Program){
        val response = try {
            userApi.createProgram(program)
        }catch(e: Exception){
            null
        }
        if (response != null && response.isSuccessful){
            programDao.createProgram(program.apply { isSynced = true })
        }else{
            programDao.createProgram(program)
        }
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
                userApi.getPrograms()
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