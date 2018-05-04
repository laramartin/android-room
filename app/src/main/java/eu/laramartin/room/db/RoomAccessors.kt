package eu.laramartin.room.db

import android.util.Log
import eu.laramartin.room.model.Task
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RoomAccessors {

    private val compositeDisposable = CompositeDisposable()

    fun loadAllTasks(dao: TaskDao, block: (List<Task>) -> Unit) {
        compositeDisposable.add(
            dao.loadAllTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ block(it) })
        )
    }

    fun insertTask(dao: TaskDao, task: Task) {
        compositeDisposable.add(
            Completable.fromCallable {
                dao.insertTask(task)
            }
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("RoomAccessors", "Insert Task successful")
                })
        )
    }

    fun deleteTask(dao: TaskDao, task: Task) {
        compositeDisposable.add(
            Completable.fromCallable {
                dao.deleteTask(task)
            }
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("RoomAccessors", "Delete Task successful")
                })
        )
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}
