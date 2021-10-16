package myfitnesspass.backend.data.remote.api

import myfitnesspass.backend.data.remote.requests.user.UserRequest
import myfitnesspass.backend.data.remote.responses.SimpleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/register")
    suspend fun registerUser(
        @Body userRequest: UserRequest
    ): Response<SimpleResponse>

    @POST("/login")
    suspend fun login(
        @Body userRequest: UserRequest
    ): Response<SimpleResponse>


}