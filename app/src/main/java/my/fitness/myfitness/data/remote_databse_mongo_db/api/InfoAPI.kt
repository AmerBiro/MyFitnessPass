package my.fitness.myfitness.data.remote_databse_mongo_db.api

import my.fitness.myfitness.data.local_database_rrom.entities.Fitness
import my.fitness.myfitness.data.local_database_rrom.entities.Info
import my.fitness.myfitness.data.remote_databse_mongo_db.requests.fitness.DeleteFitnessRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface InfoAPI {

    @POST("/createInfo")
    suspend fun createInfo(
        @Body info: Info
    ): Response<ResponseBody>

    @GET("/getInfo")
    suspend fun getInfo(): Response<List<Info>>

    @POST("/updateInfo")
    suspend fun updateInfo(
        @Body info: Info
    ): Response<ResponseBody>

}