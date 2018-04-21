package eu.laramartin.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import eu.laramartin.room.db.AppDatabase
import eu.laramartin.room.db.TaskDao
import eu.laramartin.room.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var input: String = ""
    private lateinit var dao: TaskDao
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getInstance(applicationContext)!!

        dao = db.taskDao()

        button.setOnClickListener({

            input = edit.text.toString()
            val task = Task(description = input, id = 0)
            InsertAsyncTask(dao, task).execute()

            LoadAllAsyncTask(dao, {
                for (task in it) {
                    Log.v("MainActivity", "task number " + task.id + ", description: " + task.description)
                }
            }).execute()
        })
    }
}
