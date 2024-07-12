package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.PhotoAdaptor.PhotosAdaptor
import com.example.myapplication.databinding.ActivitMainBinding
import com.example.myapplication.model.Photos
import com.example.myapplication.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding : ActivitMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitMainBinding.inflate(layoutInflater)
        val view = _binding!!.root
        setContentView(view)

//        supportActionBar!!.title = "PhotoList"
        var viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        Log.d("MainActivity" ,"this is it $viewModel")

        viewModel.getProductViewModel()
        viewModel.pList.observe(this , Observer {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = PhotosAdaptor(this,it.body()!!)
        })

    }

}