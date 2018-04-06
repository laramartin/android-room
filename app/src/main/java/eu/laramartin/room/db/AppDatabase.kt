package eu.laramartin.room.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import eu.laramartin.room.model.Task

@Database(entities = [(Task::class)], version = 1)
abstract class AppDatabase : RoomDatabase()
