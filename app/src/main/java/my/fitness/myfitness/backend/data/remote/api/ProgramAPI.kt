package my.fitness.myfitness.backend.data.remote.api

import my.fitness.myfitness.backend.data.local.entities.Program
import my.fitness.myfitness.backend.data.remote.requests.program.*
import my.fitness.myfitness.backend.data.remote.responses.SimpleResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProgramAPI {

    @POST("/createProgram")
    suspend fun createProgram(
        @Body program: Program
    ): Response<ResponseBody>

    @GET("/getPrograms")
    suspend fun getPrograms(): Response<List<Program>>

    @POST("/updateProgram")
    suspend fun updateProgram(
        @Body program: Program
    ): Response<ResponseBody>

    @POST("/shareProgramWithOthers")
    suspend fun shareProgramWithOthers(
        @Body shareProgramWithOthers: ShareProgramWithOthersRequest
    ): Response<SimpleResponse>

    @GET("/getProgramsSharedWIthMe")
    suspend fun getProgramsSharedWIthMe(): Response<List<Program>>

    @POST("/removeProgramFromSharedWithMeList")
    suspend fun removeProgramFromSharedWithMeList(
        @Body removeProgramFromSharedWithMeListRequest: RemoveProgramFromSharedWithMeListRequest
    ): Response<ResponseBody>

    @POST("/addProgramToFavorite")
    suspend fun addProgramToFavorite(
        @Body addProgramToFavoriteRequest: AddProgramToFavoriteRequest
    ): Response<ResponseBody>

    @POST("/getFavoritePrograms")
    suspend fun getFavoritePrograms(): Response<List<Program>>

    @POST("/removeProgramFromFavorite")
    suspend fun removeProgramFromFavorite(
        @Body removeProgramFromFavoriteRequest: RemoveProgramFromFavoriteRequest
    ): Response<ResponseBody>

    @POST("/deleteProgram")
    suspend fun deleteProgram(
        @Body deleteProgramRequest: DeleteProgramRequest
    ): Response<ResponseBody>

}