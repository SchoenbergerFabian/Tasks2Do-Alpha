package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.infendro.tasks2do.R
import com.infendro.tasks2do.layout.MainActivity
import com.infendro.tasks2do.layout.Task
import kotlinx.android.synthetic.main.dialog_newtask.*

class Dialog_NewTask(private val activity: Activity) : Dialog(activity) {

    val task = Task()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_newtask)

        textview_due.text = task.getDueString(activity.getString(R.string.format_date),activity.getString(R.string.format_time))

        button_pickdate.setOnClickListener {
            //TODO pick date
        }

        button_picktime.setOnClickListener{
            //TODO pick time
        }

        button_create.setOnClickListener{
            //TODO check if valid
            MainActivity.tasks.addTask(task)
            dismiss()
        }

        button_cancel.setOnClickListener{
            dismiss()
        }

    }

}