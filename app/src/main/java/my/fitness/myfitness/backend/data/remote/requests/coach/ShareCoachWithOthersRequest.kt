package my.fitness.myfitness.backend.data.remote.requests.coach

data class ShareCoachWithOthersRequest(
    val coachId: String,
    val email: String,
    val owner: String
)