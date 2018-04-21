package eu.laramartin.room.list

import android.support.v7.widget.RecyclerView
import android.view.View
import eu.laramartin.room.model.Task
import kotlinx.android.synthetic.main.list_item.view.*

class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(task: Task) {
        itemView.text.text = task.description
    }
}
