package com.infendro.tasks2do

import com.infendro.tasks2do.layout.Task

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

    fun addTask(task: Task){
        tasks.add(task)
    }

    fun removeTask(task: Task){
        tasks.remove(task)
    }
}