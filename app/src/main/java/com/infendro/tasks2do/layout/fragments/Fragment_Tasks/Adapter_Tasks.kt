package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.app.Activity
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Tasks
import com.infendro.tasks2do.Task
import com.infendro.tasks2do.layout.MainActivity

class Adapter_Tasks(private val activity: Activity) : RecyclerView.Adapter<Adapter_Tasks.ViewHolder>() {

    private val sortedTasks : SortedList<Task>

    init{
        sortedTasks = SortedList(Task::class.java, object : SortedListAdapterCallback<Task>(this) {
            override fun areItemsTheSame(task1: Task, task2: Task): Boolean {
                return task1==task2
            }

            override fun compare(task1: Task, task2: Task): Int {
                return task1.compareTo(task2)
            }

            override fun areContentsTheSame(task1: Task, task2: Task): Boolean {
                return task1.compareTo(task2)==0
            }
        })
    }

    fun addTask(task: Task){
        sortedTasks.add(task)
    }

    fun removeTask(task: Task){
        sortedTasks.remove(task)
    }

    fun addTasks(tasks: List<Task>){
        sortedTasks.addAll(tasks)
    }

    class ViewHolder(private val activity: Activity, view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        private val textview_title: TextView = view.findViewById(R.id.textview_title)
        private val textview_due: TextView = view.findViewById(R.id.textview_due)

        private lateinit var task: Task

        init {
            view.setOnCreateContextMenuListener(this)
            // Define click listener for the ViewHolder's View.
        }

        fun bind(task : Task){
            this.task=task
            textview_title.text = task.title
            textview_due.text = task.getDueString(activity.getString(R.string.format_date),activity.getString(R.string.format_time))
        }

        override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
            activity.menuInflater.inflate(R.menu.contextmenu_task, menu)
            menu.findItem(R.id.menuitem_edit).setOnMenuItemClickListener {
                Dialog_EditTask(activity,task).show()
                true
            }
            menu.findItem(R.id.menuitem_delete).setOnMenuItemClickListener {
                MainActivity.tasks.removeTask(task)
                Fragment_Tasks.adapter_tasks.removeTask(task)
                MainActivity.toast(activity.getString(R.string.removed))
                true
            }
            menu.findItem(R.id.menuitem_details).setOnMenuItemClickListener {
                Dialog_TaskDetails(activity, task).show()
                true
            }
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
        viewHolder.bind(sortedTasks[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = sortedTasks.size()

    fun getItem(position: Int) : Task {
        return sortedTasks[position]
    }

}