package com.infendro.tasks2do

class Storage {
    companion object{
        fun save(tasks: Tasks){
            //TODO save (gson)
        }

        fun load() : Tasks{
            val tasks = Tasks()

            //TODO load (gson)

            return tasks
        }
    }
}