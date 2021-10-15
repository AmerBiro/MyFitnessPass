package my.fitness.myfitness.data.remote_databse_mongo_db.api

import my.fitness.myfitness.data.remote_databse_mongo_db.requests.user.UserRequest
import my.fitness.myfitness.data.remote_databse_mongo_db.responses.SimpleResponse
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