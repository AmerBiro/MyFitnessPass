package myfitnesspass.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locally_deleted_program_ids")
data class LocallyDeletedProgramID (
    @PrimaryKey(autoGenerate = false)
    val deletedProgramID: String


    )