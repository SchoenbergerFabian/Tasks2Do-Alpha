package com.infendro.tasks2do.layout.fragments.Fragment_Tasks

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.infendro.tasks2do.R
import com.infendro.tasks2do.layout.MainActivity
import kotlinx.android.synthetic.main.fragment_tasks.*

class Fragment_Tasks : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerview_tasks.adapter = Adapter_Tasks(requireActivity(),MainActivity.tasks)

        button_create.setOnClickListener {
            Dialog_NewTask(requireActivity()).show()
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuitem_edit -> {
                Toast.makeText(requireActivity(),"EDIT",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menuitem_delete -> {
                Toast.makeText(requireActivity(),"DELETE",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menuitem_details -> {
                Toast.makeText(requireActivity(),"DETAILS",Toast.LENGTH_SHORT).show()
                true
            }
        }
        return super.onContextItemSelected(item)
    }

}