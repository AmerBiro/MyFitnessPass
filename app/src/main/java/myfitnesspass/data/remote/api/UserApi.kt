package myfitnesspass.data.remote.api

import myfitnesspass.data.local.entities.Program
import myfitnesspass.data.remote.requests.program.DeleteProgramRequest
import myfitnesspass.data.remote.requests.program.ShareProgramWithOthersRequest
import myfitnesspass.data.remote.requests.user.UserRequest
import myfitnesspass.data.remote.responses.SimpleResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
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



    @POST("/createProgram")
    suspend fun createProgram(
        @Body program: Program
    ): Response<ResponseBody>

    @GET("/getPrograms")
    suspend fun getPrograms(): Response<List<Program>>

    @POST("/deleteProgram")
    suspend fun deleteProgram(
        @Body deleteProgramRequest: DeleteProgramRequest
    ): Response<ResponseBody>

    @POST("/shareProgramWithOthers")
    suspend fun shareProgramWithOthers(
        @Body shareProgramWithOthersRequest: ShareProgramWithOthersRequest
    ): Response<SimpleResponse>



}
