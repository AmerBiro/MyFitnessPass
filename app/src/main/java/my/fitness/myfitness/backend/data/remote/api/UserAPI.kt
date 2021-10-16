package my.fitness.myfitness.backend.data.remote.api

import my.fitness.myfitness.backend.data.remote.requests.user.UserRequest
import my.fitness.myfitness.backend.data.remote.responses.SimpleResponse
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