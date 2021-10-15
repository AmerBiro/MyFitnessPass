package com.noteapp.database.collections

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "coach")
data class Coach(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: Int,
    val website: String,
    val creationDate: Long,
    val lastUpdateDate: Long,
    val hasAccess: List<String>,
    val parent: String,
    val owner: String,
    val favoriteStatus: Int,
    @Expose(deserialize = false, serialize = false)
    val isSynced: Boolean = false,
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()
)