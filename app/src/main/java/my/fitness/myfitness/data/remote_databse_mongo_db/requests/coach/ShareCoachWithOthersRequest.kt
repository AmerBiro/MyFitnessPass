package my.fitness.myfitness.data.remote_databse_mongo_db.requests.coach

data class ShareCoachWithOthersRequest(
    val coachId: String,
    val email: String,
    val owner: String
)