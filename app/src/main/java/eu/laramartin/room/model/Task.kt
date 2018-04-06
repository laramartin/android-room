package eu.laramartin.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
        @PrimaryKey private val id: Int,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "status") val status: Int)
