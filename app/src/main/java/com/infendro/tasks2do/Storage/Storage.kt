package com.infendro.tasks2do.Storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.infendro.tasks2do.Tasks
import com.infendro.tasks2do.Storage.LocalDateAdapter
import com.infendro.tasks2do.layout.MainActivity
import java.io.*
import java.time.LocalDate
import java.time.LocalTime

class Storage {
    companion object{

        private val FILENAME_SAVE = "Tasks.json"

        fun save(tasks: Tasks){
            val pw = PrintWriter(OutputStreamWriter(MainActivity.activity.openFileOutput(FILENAME_SAVE, Context.MODE_PRIVATE)))
            val gson = GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate::class.java,LocalDateAdapter())
                .registerTypeAdapter(LocalTime::class.java,LocalTimeAdapter())
                .create()
            pw.print(gson.toJson(tasks))
            pw.flush()
            pw.close()
        }

        fun load() : Tasks {
            var tasks = Tasks()

            try {
                BufferedReader(InputStreamReader(MainActivity.activity.openFileInput(FILENAME_SAVE))).use {
                    val gson = GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(LocalDate::class.java,LocalDateAdapter())
                        .registerTypeAdapter(LocalTime::class.java,LocalTimeAdapter())
                        .create()
                    tasks = gson.fromJson(it.readText(), object : TypeToken<Tasks>() {}.type)
                }
            }catch(ex: FileNotFoundException){
                //File does not yet exist
            }

            return tasks
        }
    }
}