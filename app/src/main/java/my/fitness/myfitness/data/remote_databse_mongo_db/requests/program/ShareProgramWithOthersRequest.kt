package my.fitness.myfitness.data.remote_databse_mongo_db.requests.program

data class ShareProgramWithOthersRequest(
    val programId: String,
    val email: String,
    val owner: String
)