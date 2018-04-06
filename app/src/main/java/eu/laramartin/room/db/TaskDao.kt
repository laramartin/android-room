package eu.laramartin.room.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import eu.laramartin.room.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun loadAllTasks(): List<Task>

    @Insert
    fun insertTask(task: Task)
}
