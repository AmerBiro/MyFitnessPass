package my.fitness.myfitness.data.remote_databse_mongo_db.requests.exercise

data class ShareExerciseWithOthersRequest(
    val exerciseId: String,
    val email: String,
    val owner: String
)