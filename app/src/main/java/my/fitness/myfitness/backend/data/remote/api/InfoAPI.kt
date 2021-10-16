package my.fitness.myfitness.backend.data.remote.api

import my.fitness.myfitness.backend.data.local.entities.Info
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