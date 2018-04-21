package eu.laramartin.room

import android.os.AsyncTask
import android.util.Log
import eu.laramartin.room.db.TaskDao
import eu.laramartin.room.model.Task

class InsertAsyncTask(private val dao: TaskDao, private val task: Task) : AsyncTask<Task, Unit, Unit>() {
    override fun doInBackground(vararg params: Task?) {
        dao.insertTask(task)
    }
}

class LoadAllAsyncTask(private val dao: TaskDao) : AsyncTask<Unit, Unit, List<Task>>() {
    override fun doInBackground(vararg params: Unit?): List<Task>? {
        return dao.loadAllTasks()
    }

    override fun onPostExecute(result: List<Task>?) {
        super.onPostExecute(result)
        if (result != null) {
            for (task in result) {
                Log.v("MainActivity", "task number " + task.id + ", description: " + task.description)
            }
        }
    }
}
