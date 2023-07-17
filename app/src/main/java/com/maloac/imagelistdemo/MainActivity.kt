package com.maloac.imagelistdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.maloac.imagelistdemo.adapter.ImageListAdapter
import com.maloac.imagelistdemo.databinding.ActivityMainBinding
import com.maloac.imagelistdemo.model.ImageObject

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: ImageListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ImageListAdapter(listOf(ImageObject(imageName = "First Image", imageUrl = "https://asia.olympus-imaging.com/content/000107506.jpg"),
        ImageObject(imageName = "Second Image", imageUrl = "https://asia.olympus-imaging.com/content/000107506.jpg")
        ), context = this)

        binding.rvImages.adapter = adapter
        binding.rvImages.layoutManager = LinearLayoutManager(this)

        Glide.with(this).load("https://asia.olympus-imaging.com/content/000107506.jpg").into(binding.ivTestImage)

    }


}