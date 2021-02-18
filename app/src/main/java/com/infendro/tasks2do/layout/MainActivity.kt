package com.infendro.tasks2do.layout

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.infendro.tasks2do.R
import com.infendro.tasks2do.Storage.Storage
import com.infendro.tasks2do.Tasks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{

        lateinit var activity : Activity

        var tasks = Tasks()

        fun toast(text: String){
            Toast.makeText(activity,text,Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activity=this

        tasks = Storage.load()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set toolbar
        toolbar.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)
    }


}