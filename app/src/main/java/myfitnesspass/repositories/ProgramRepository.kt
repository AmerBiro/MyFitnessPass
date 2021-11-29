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
                    // TODO: Insert programs in database
                }
            },
            shouldFetch = {
                checkForInternetConnection(context)
            }
        )
    }


}