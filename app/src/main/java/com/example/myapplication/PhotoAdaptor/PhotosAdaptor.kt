package com.example.myapplication.PhotoAdaptor

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DetailsActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.PhotoitemBinding
import com.example.myapplication.model.Photos
import com.squareup.picasso.Picasso

class PhotosAdaptor (private val context: Context, private val productList : List<Photos> )
    : RecyclerView.Adapter<PhotosAdaptor.ItemViewHolder>() {

    inner class ItemViewHolder(val binding : PhotoitemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =  PhotoitemBinding.inflate(LayoutInflater.from(parent.context)
            , parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder,
                                  @SuppressLint("RecyclerView") position: Int)
    {
        with(holder){
            with(productList[position]){
              //  binding.productItemTitleTv.text  = this.albumId.toString()
                binding.detail.text = this.title.toString()
                Picasso.get()
                    .load(this.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into( binding.productItemIv)
                binding.card.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("url", this.thumbnailUrl)
                    bundle.putString("detail", this.title)
                    val  intent = Intent(context, DetailsActivity::class.java)
                    intent.putExtras(bundle)
                    context.startActivity(intent) }
            }
        }


    }
    override fun getItemCount(): Int {
        return productList.size
    }
}