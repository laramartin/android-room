package eu.laramartin.room.db

import android.util.Log
import eu.laramartin.room.model.Task
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomAccessors {

    fun loadAllTasks(dao: TaskDao, block: (List<Task>) -> Unit) {
        dao.loadAllTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ block(it) })
    }

    fun insertTask(dao: TaskDao, task: Task) {
        Completable.fromCallable {
            dao.insertTask(task)
        }
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("RoomAccessors", "Insert Task successful")
            })
    }

    fun deleteTask(dao: TaskDao, task: Task) {
        Completable.fromCallable {
            dao.deleteTask(task)
        }
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("RoomAccessors", "Delete Task successful")
            })
    }
}
