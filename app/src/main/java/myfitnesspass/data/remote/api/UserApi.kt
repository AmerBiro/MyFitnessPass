package myfitnesspass.data.remote.api

import myfitnesspass.data.remote.requests.user.UserRequest
import myfitnesspass.data.remote.responses.SimpleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/register")
    suspend fun register(
        @Body registerRequest: UserRequest
    ): Response<SimpleResponse>

    @POST("/login")
    suspend fun login(
        @Body loginRequest: UserRequest
    ): Response<SimpleResponse>
}
