package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.Window
import androidx.core.widget.doOnTextChanged
import com.infendro.tasks2do.R
import com.infendro.tasks2do.layout.MainActivity
import com.infendro.tasks2do.Task
import kotlinx.android.synthetic.main.dialog_newtask.*
import java.time.LocalDate
import java.time.LocalTime

class Dialog_NewTask(private val activity: Activity) : Dialog(activity) {

    val task = Task()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_newtask)

        //title
        edittext_title.doOnTextChanged { text, _, _, _ ->
            task.title=text.toString()
        }

        //due date and time
        setText_duedatetime()

        button_pickdate.setOnClickListener {
            DatePickerDialog(activity,
                DatePickerDialog.OnDateSetListener{ _,year,month,dayOfMonth ->
                    task.dueDate = LocalDate.of(year,month+1,dayOfMonth)
                    setText_duedatetime()
                },
                task.dueDate.year,
                task.dueDate.monthValue-1,
                task.dueDate.dayOfMonth).show()
        }

        button_picktime.setOnClickListener{
            TimePickerDialog(activity,
                TimePickerDialog.OnTimeSetListener{_,hourOfDay,minute ->
                    task.dueTime = LocalTime.of(hourOfDay,minute)
                    setText_duedatetime()
                },
                task.dueTime.hour,
                task.dueTime.minute,
                true).show()
        }

        //description
        edittext_description.doOnTextChanged { text, _, _, _ ->
            task.description=text.toString()
        }

        //buttons
        button_create.setOnClickListener{

            if(task.title.trim()!=""){
                MainActivity.tasks.addTask(task)
                Fragment_Tasks.adapter_tasks.addTask(task)
                dismiss()
            }else{
                MainActivity.toast(activity.getString(R.string.invalidinput))
            }

        }

        button_cancel.setOnClickListener{
            dismiss()
        }

    }

    fun setText_duedatetime(){
        textview_due.text = task.getDueString(activity.getString(R.string.format_date),activity.getString(R.string.format_time))
    }

}