package eu.laramartin.room.db

import android.os.AsyncTask
import eu.laramartin.room.model.Task

class DeleteTaskAsyncTask(private val dao: TaskDao, private val task: Task) : AsyncTask<Task, Unit, Unit>() {
    override fun doInBackground(vararg params: Task?) {
        dao.deleteTask(task)
    }
}
