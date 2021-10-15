package com.noteapp.database.collections

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "info")
data class Info(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val birthdate: Long,
    val height: Double,
    val weight: Double,
    val imageURL: String,
    val creationDate: Long,
    val lastUpdateDate: Long,
    val parent: String,
    val owner: String,
    @Expose(deserialize = false, serialize = false)
    val isSynced: Boolean = false,
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()
)