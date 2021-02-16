package com.infendro.tasks2do.layout

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Task {

    constructor()
    constructor(title: String, description: String, dueDate: LocalDate, dueTime: LocalTime){
        this.title = title
        this.description = description
        this.dueDate = dueDate
        this.dueTime = dueTime
    }

    var title = ""
    var description = ""
    var dueDate : LocalDate = LocalDate.now()
    var dueTime : LocalTime? = null

    fun getDueString(datePattern: String, timePattern: String) : String{
        return when(dueTime){
            null -> {
                val datetimeFormat = DateTimeFormatter.ofPattern("$datePattern")
                datetimeFormat.format(dueDate)
            }
            else -> {
                val datetimeFormat = DateTimeFormatter.ofPattern("$datePattern $timePattern")
                datetimeFormat.format(dueDate.atTime(dueTime))
            }
        }
    }

}