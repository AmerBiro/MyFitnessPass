package my.fitness.myfitness.data.remote_databse_mongo_db.api

import my.fitness.myfitness.data.local_database_rrom.entities.Fitness
import my.fitness.myfitness.data.remote_databse_mongo_db.requests.fitness.DeleteFitnessRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FitnessAPI {

    @POST("/createFitness")
    suspend fun createFitness(
        @Body fitness: Fitness
    ): Response<ResponseBody>

    @GET("/getFitness")
    suspend fun getFitness(): Response<List<Fitness>>

    @POST("/updateFitness")
    suspend fun updateFitness(
        @Body fitness: Fitness
    ): Response<ResponseBody>

    @POST("/deleteFitness")
    suspend fun deleteFitness(
        @Body deleteFitnessRequest: DeleteFitnessRequest
    ): Response<ResponseBody>

}