package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.Window
import androidx.core.widget.doOnTextChanged
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Task
import com.infendro.tasks2do.layout.MainActivity
import kotlinx.android.synthetic.main.dialog_edittask.*
import java.time.LocalDate
import java.time.LocalTime

class Dialog_EditTask(private val activity: Activity, private val task: Task) : Dialog(activity) {

    val tempTask = Task()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_edittask)

        //set up
        tempTask.title=task.title
        tempTask.dueDate=task.dueDate
        tempTask.dueTime=task.dueTime
        tempTask.description=task.description

        //title
        edittext_title.setText(tempTask.title)

        edittext_title.doOnTextChanged { text, _, _, _ ->
            tempTask.title=text.toString()
        }

        //due date and time
        setText_duedatetime()

        button_pickdate.setOnClickListener {
            DatePickerDialog(activity,
                DatePickerDialog.OnDateSetListener{ _, year, month, dayOfMonth ->
                    tempTask.dueDate = LocalDate.of(year,month+1,dayOfMonth)
                    setText_duedatetime()
                },
                tempTask.dueDate.year,
                tempTask.dueDate.monthValue-1,
                tempTask.dueDate.dayOfMonth).show()
        }

        button_picktime.setOnClickListener{
            TimePickerDialog(activity,
                TimePickerDialog.OnTimeSetListener{ _, hourOfDay, minute ->
                    tempTask.dueTime = LocalTime.of(hourOfDay,minute)
                    setText_duedatetime()
                },
                tempTask.dueTime.hour,
                tempTask.dueTime.minute,
                true).show()
        }

        //description
        edittext_description.setText(task.description)

        edittext_description.doOnTextChanged { text, _, _, _ ->
            tempTask.description=text.toString()
        }

        //buttons
        button_save.setOnClickListener{

            if(tempTask.title.trim()!=""){
                //remove old
                MainActivity.tasks.removeTask(task)
                Fragment_Tasks.adapter_tasks.removeTask(task)
                //add new
                MainActivity.tasks.addTask(tempTask)
                Fragment_Tasks.adapter_tasks.addTask(tempTask)

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
        textview_due.text = tempTask.getDueString(activity.getString(R.string.format_date),activity.getString(
            R.string.format_time))
    }

}