package eu.laramartin.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import eu.laramartin.room.db.AppDatabase
import eu.laramartin.room.db.InsertAsyncTask
import eu.laramartin.room.db.RoomAccessors
import eu.laramartin.room.db.TaskDao
import eu.laramartin.room.list.TasksAdapter
import eu.laramartin.room.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var input: String = ""
    private lateinit var dao: TaskDao
    private lateinit var db: AppDatabase
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getInstance(applicationContext)!!

        dao = db.taskDao()

        initRecycler()

        RoomAccessors().loadAllTasks(dao, { tasksAdapter.loadData(it) })

        button.setOnClickListener({
            input = edit.text.toString()
            if (input.isEmpty()) {
                return@setOnClickListener
            }
            val task = Task(description = input, id = 0)
            InsertAsyncTask(dao, task).execute()
        })
    }

    private fun initRecycler() {
        tasksAdapter = TasksAdapter(dao)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = tasksAdapter
    }
}
