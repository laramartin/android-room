package eu.laramartin.room.db

import eu.laramartin.room.model.Task
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomAccessors {

    fun loadAllTasks(dao: TaskDao, block: (List<Task>) -> Unit) {
        dao.loadAllTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ block(it)})
    }
}
