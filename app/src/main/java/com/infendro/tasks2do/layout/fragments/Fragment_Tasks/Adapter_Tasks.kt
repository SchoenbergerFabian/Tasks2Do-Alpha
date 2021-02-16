package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.app.Activity
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Tasks
import com.infendro.tasks2do.layout.Task
import kotlinx.android.synthetic.main.view_task.view.*

class Adapter_Tasks(private val activity: Activity,private val tasks : Tasks) : RecyclerView.Adapter<Adapter_Tasks.ViewHolder>() {

    class ViewHolder(val activity: Activity, view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        val textview_title: TextView
        val textview_due: TextView

        init {
            textview_title = view.findViewById(R.id.textview_title)
            textview_due = view.findViewById(R.id.textview_due)
            view.setOnCreateContextMenuListener(this)
            // Define click listener for the ViewHolder's View.
        }

        fun bind(task : Task){
            textview_title.text = task.title
            textview_due.text = task.getDueString(activity.getString(R.string.format_date),activity.getString(R.string.format_time))
        }

        override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
            activity.menuInflater.inflate(R.menu.contextmenu_task, menu)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_task, viewGroup, false)

        return ViewHolder(activity,view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(tasks.getTask(position))
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = tasks.size()

}