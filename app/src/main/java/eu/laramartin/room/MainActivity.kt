package eu.laramartin.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.laramartin.room.db.AppDatabase
import eu.laramartin.room.db.TaskDao


class MainActivity : AppCompatActivity() {

    private var input: String = ""
    private lateinit var dao : TaskDao
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getInstance(applicationContext)!!
//        dao = db.taskDao()
//
//        input = edit.text.toString()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        AppDatabase.destroyInstance()
//    }
}
