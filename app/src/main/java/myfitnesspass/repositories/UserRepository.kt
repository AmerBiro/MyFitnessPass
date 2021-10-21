package myfitnesspass.repositories

import android.app.Application
import myfitnesspass.data.local.dao.ProgramDao
import myfitnesspass.data.remote.api.UserApi
import myfitnesspass.data.remote.requests.user.UserRequest
import myfitnesspass.other.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: UserApi,
    private val context: Application
) {
    suspend fun register(email: String, password: String) = withContext(Dispatchers.IO) {
        try {
            val response = userApi.register(UserRequest(email, password))
            if(response.isSuccessful && response.body()!!.successful) {
                Resource.success(response.body()?.message)
            } else {
                Resource.error(response.body()?.message ?: response.message(), null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't connect to the servers. Check your internet connection", null)
        }
    }

    suspend fun login(email: String, password: String) = withContext(Dispatchers.IO) {
        try {
            val response = userApi.login(UserRequest(email, password))
            if(response.isSuccessful && response.body()!!.successful) {
                Resource.success(response.body()?.message)
            } else {
                Resource.error(response.body()?.message ?: response.message(), null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't connect to the servers. Check your internet connection", null)
        }
    }


}