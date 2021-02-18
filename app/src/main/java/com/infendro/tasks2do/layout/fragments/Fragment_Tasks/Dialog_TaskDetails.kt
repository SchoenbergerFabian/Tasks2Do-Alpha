package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Task
import kotlinx.android.synthetic.main.dialog_taskdetails.*

class Dialog_TaskDetails(private val activity: Activity, private val task: Task) : Dialog(activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_taskdetails)

        //set up
        textview_title.setText(task.title)
        setText_duedatetime()
        textview_description.setText(task.description)

        //buttons
        button_close.setOnClickListener{
            dismiss()
        }

    }

    fun setText_duedatetime(){
        textview_due.text = this.task.getDueString(activity.getString(R.string.format_date),activity.getString(
            R.string.format_time))
    }

}