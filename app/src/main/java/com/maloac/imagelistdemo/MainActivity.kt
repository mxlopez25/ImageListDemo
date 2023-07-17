package com.maloac.imagelistdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.maloac.imagelistdemo.adapter.ImageListAdapter
import com.maloac.imagelistdemo.databinding.ActivityMainBinding
import com.maloac.imagelistdemo.model.ImageObject
import com.maloac.imagelistdemo.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: MainViewModel

    lateinit var adapter: ImageListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        adapter = ImageListAdapter(viewModel.data.value!!.toList(), this)
        binding.rvImages.adapter = adapter
        binding.rvImages.layoutManager = LinearLayoutManager(this)

        binding.btnAddData.setOnClickListener {
                viewModel.addData(ImageObject(imageName = "Another Image", "https://static.remove.bg/sample-gallery/graphics/bird-thumbnail.jpg"))
        }

        viewModel.data.observe(this, Observer {
            adapter = ImageListAdapter(it, this)
            binding.rvImages.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        viewModel.count.observe(this, Observer {
            binding.tvCounter.text = "Counter: $it"
        })


    }


}