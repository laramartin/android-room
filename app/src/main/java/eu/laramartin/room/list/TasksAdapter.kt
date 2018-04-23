package eu.laramartin.room.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.laramartin.room.R
import eu.laramartin.room.db.TaskDao
import eu.laramartin.room.model.Task

class TasksAdapter(private val dao: TaskDao) : RecyclerView.Adapter<TasksViewHolder>() {

    private var tasks: List<Task> = emptyList()

    fun loadData(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    fun removeTask(task: Task, position: Int) {
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                        R.layout.list_item, parent, false)
        return TasksViewHolder(view, dao)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.bind(tasks[position])
    }
}
