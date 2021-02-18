package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Storage.Storage
import com.infendro.tasks2do.layout.MainActivity
import kotlinx.android.synthetic.main.fragment_tasks.*

class Fragment_Tasks : Fragment() {

    companion object{
        lateinit var adapter_tasks : Adapter_Tasks
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter_tasks = Adapter_Tasks(requireActivity())
        adapter_tasks.addTasks(MainActivity.tasks.getTasks())
        recyclerview_tasks.adapter = adapter_tasks

        button_create.setOnClickListener {
            Dialog_NewTask(requireActivity()).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_tasks,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuitem_save -> {
                Storage.save(MainActivity.tasks)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}