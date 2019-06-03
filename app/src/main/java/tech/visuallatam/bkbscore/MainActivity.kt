package tech.visuallatam.bkbscore

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.visuallatam.bkbscore.Database.ViewModel.partidoViewModel
import tech.visuallatam.bkbscore.GUI.adapter

class MainActivity : AppCompatActivity() {

    lateinit var adapter : adapter
    lateinit var viewModel :partidoViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bind()
    }


    fun bind(){

        adapter = adapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(partidoViewModel::class.java)

        recycler.apply{
            adapter=this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.todos().observe(this , Observer { adapter.updateList(it) })

        main_add_button.setOnClickListener{
            val intent = Intent(this,new_match::class.java)
            startActivity(intent)
        }

    }
}

