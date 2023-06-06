package com.nc.internship_assignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nc.internship_assignment.adapter.MyAdapter
import com.nc.internship_assignment.model.UserData

class showImagesActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var listOfPhoto: List<UserData>
    lateinit var viewModelList: ViewModelList
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_images)
        Log.d("nc", "======================== show image");
        recyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        prepareRecyclerView()

//        viewModelList=ViewModelProvider.of(this).get(ViewModelList::class.java)
        viewModelList = ViewModelProvider(this)[ViewModelList::class.java]
        viewModelList.makeAPICall()

        viewModelList.observeMovieLiveData().observe(this, Observer { movieList ->
            myAdapter.updateDataList(movieList)
        })


    }

    private fun prepareRecyclerView() {
        myAdapter = MyAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter

        }
    }
}