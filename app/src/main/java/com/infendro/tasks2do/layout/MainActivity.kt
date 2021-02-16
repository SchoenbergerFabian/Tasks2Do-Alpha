package com.infendro.tasks2do.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Tasks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val tasks = Tasks()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //load


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set toolbar
        toolbar.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        test_addTask(10)
    }

    fun test_addTask(amount: Int){
        for(number in 0 until amount){
            test_addTask()
        }
    }

    fun test_addTask(){
        val task = Task()
        task.title = "Test"
        tasks.addTask(task)
    }
}