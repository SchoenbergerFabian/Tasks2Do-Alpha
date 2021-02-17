package com.infendro.tasks2do

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Task : Comparable<Task> {

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
    var dueTime : LocalTime = LocalTime.now()

    fun getDueString(datePattern: String, timePattern: String) : String{
        val datetimeFormat = DateTimeFormatter.ofPattern("$datePattern $timePattern")
        return datetimeFormat.format(dueDate.atTime(dueTime))
    }

    override fun compareTo(other: Task): Int {
        val compareDueDate = dueDate.compareTo(other.dueDate)
        if(compareDueDate==0){
            return dueTime.compareTo(other.dueTime)
        }
        return compareDueDate
    }

}