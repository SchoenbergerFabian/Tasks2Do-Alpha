package com.infendro.tasks2do

import java.util.*
import kotlin.collections.ArrayList

class Tasks {

    private val tasks = ArrayList<Task>()

    fun size() : Int {
        return tasks.size
    }

    fun setTasks(tasks: List<Task>){
        this.tasks.clear()
        this.tasks.addAll(tasks)
    }

    fun getTask(index: Int) : Task {
        return tasks[index]
    }

    fun getTasks() : List<Task>{
        return tasks
    }

    fun addTask(task: Task){
        tasks.add(task)
        //tasks.sort()
    }

    fun removeTask(task: Task){
        tasks.remove(task)
    }
}