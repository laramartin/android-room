package eu.laramartin.room.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import eu.laramartin.room.db.RoomAccessors
import eu.laramartin.room.db.TaskDao
import eu.laramartin.room.model.Task
import kotlinx.android.synthetic.main.list_item.view.*

class TasksViewHolder(itemView: View, dao: TaskDao) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private lateinit var currentTask: Task
    private var currentDao: TaskDao = dao

    init {
        itemView.checkBox.setOnClickListener(this)
    }

    fun bind(task: Task) {
        currentTask = task
        itemView.text.text = task.description
    }

    override fun onClick(v: View?) {
        val checkBox: CheckBox = v!!.checkBox
        if (checkBox.isChecked) {
            RoomAccessors().deleteTask(currentDao, currentTask)
        }
    }
}
