package my.fitness.myfitness.data.remote_databse_mongo_db.api

import my.fitness.myfitness.data.local_database_rrom.entities.Coach
import my.fitness.myfitness.data.remote_databse_mongo_db.requests.coach.*
import my.fitness.myfitness.data.remote_databse_mongo_db.responses.SimpleResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoachAPI {

    @POST("/createCoach")
    suspend fun createCoach(
        @Body coach: Coach
    ): Response<ResponseBody>

    @GET("/getCoaches")
    suspend fun getCoaches(): Response<List<Coach>>

    @POST("/updateCoach")
    suspend fun updateCoach(
        @Body coach: Coach
    ): Response<ResponseBody>

    @POST("/shareCoachWithOthers")
    suspend fun shareCoachWithOthers(
        @Body shareCoachWithOthers: ShareCoachWithOthersRequest
    ): Response<SimpleResponse>

    @GET("/getCoachesSharedWIthMe")
    suspend fun getCoachesSharedWIthMe(): Response<List<Coach>>

    @POST("/removeCoachFromSharedWithMeList")
    suspend fun removeCoachFromSharedWithMeList(
        @Body removeCoachFromSharedWithMeListRequest: RemoveCoachFromSharedWithMeListRequest
    ): Response<ResponseBody>

    @POST("/addCoachToFavorite")
    suspend fun addCoachToFavorite(
        @Body addCoachToFavoriteRequest: AddCoachToFavoriteRequest
    ): Response<ResponseBody>

    @POST("/getFavoriteCoach")
    suspend fun getFavoriteCoaches(): Response<List<Coach>>

    @POST("/removeCoachFromFavorite")
    suspend fun removeCoachFromFavorite(
        @Body removeCoachFromFavoriteRequest: RemoveCoachFromFavoriteRequest
    ): Response<ResponseBody>

    @POST("/deleteCoach")
    suspend fun deleteCoach(
        @Body deleteCoachRequest: DeleteCoachRequest
    ): Response<ResponseBody>

}