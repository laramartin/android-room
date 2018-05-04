package eu.laramartin.room.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import eu.laramartin.room.model.Task
import io.reactivex.Flowable

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun loadAllTasks(): Flowable<List<Task>>

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}
