package my.fitness.myfitness.backend.data.remote.requests.program

data class ShareProgramWithOthersRequest(
    val programId: String,
    val email: String,
    val owner: String
)