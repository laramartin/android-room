package eu.laramartin.room.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
        @PrimaryKey(autoGenerate = true) val id: Long,
        val description: String,
        val status: Int)
