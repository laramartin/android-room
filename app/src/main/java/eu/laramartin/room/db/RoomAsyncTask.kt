package eu.laramartin.room.db

import android.os.AsyncTask
import eu.laramartin.room.model.Task

class InsertAsyncTask(private val dao: TaskDao, private val task: Task) : AsyncTask<Task, Unit, Unit>() {
    override fun doInBackground(vararg params: Task?) {
        dao.insertTask(task)
    }
}

//class LoadAllAsyncTask(private val dao: TaskDao, private val block: (List<Task>) -> Unit) : AsyncTask<Unit, Unit, List<Task>>() {
//    override fun doInBackground(vararg params: Unit?): List<Task>? {
//        return dao.loadAllTasks()
//    }
//
//    override fun onPostExecute(result: List<Task>?) {
//        super.onPostExecute(result)
//        if (result != null) {
//            block(result)
//        }
//    }
//}

class DeleteTaskAsyncTask(private val dao: TaskDao, private val task: Task) : AsyncTask<Task, Unit, Unit>() {
    override fun doInBackground(vararg params: Task?) {
        dao.deleteTask(task)
    }
}
