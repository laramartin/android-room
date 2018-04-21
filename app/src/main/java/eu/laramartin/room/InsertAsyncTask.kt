package eu.laramartin.room

import android.os.AsyncTask
import eu.laramartin.room.db.TaskDao
import eu.laramartin.room.model.Task

class InsertAsyncTask(private val dao: TaskDao, private val task: Task) : AsyncTask<Task, Unit, Unit>() {
    override fun doInBackground(vararg params: Task?) {
        dao.insertTask(task)
    }
}
