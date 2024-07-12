package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.NewmainBinding
import com.squareup.picasso.Picasso


class DetailsActivity : AppCompatActivity() {

    private var _binding : NewmainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = NewmainBinding.inflate(layoutInflater)
        val view = _binding!!.root
        setContentView(view)
        val mIntent = intent
        val url = mIntent.getStringExtra("url")
        val details = mIntent.getStringExtra("detail")
        binding.tvTitle.text=details
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into( binding.photourl)


    }

}